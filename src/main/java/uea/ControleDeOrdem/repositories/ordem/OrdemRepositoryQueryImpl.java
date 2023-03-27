package uea.ControleDeOrdem.repositories.ordem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uea.ControleDeOrdem.dto.ResumoOrdemDto;
import uea.ControleDeOrdem.models.Ordem;
import uea.ControleDeOrdem.repositories.filters.OrdemFilter;


public class OrdemRepositoryQueryImpl implements OrdemRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoOrdemDto> filtrar(OrdemFilter ordemFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoOrdemDto> criteria = builder.createQuery(ResumoOrdemDto.class);
		Root<Ordem> root = criteria.from(Ordem.class); 
		criteria.select(builder.construct(ResumoOrdemDto.class,root.get("codigo"), root.get("descricao"),root.get("status"),
				root.get("dataSolicitacao"), root.get("dataFinalizado"),root.get("servicoRealizado"))); 
		Predicate[] predicates = criarRestricoes(ordemFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		// List<ResumoOrdemDto> returnList =
		// manager.createQuery(criteria).getResultList();
		TypedQuery<ResumoOrdemDto> query = manager.createQuery(criteria);

		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(ordemFilter));
	}

	private Long total(OrdemFilter ordemFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Ordem> root = criteria.from(Ordem.class);

		Predicate[] predicates = criarRestricoes(ordemFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<ResumoOrdemDto> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber(), totalRegistroPagina = pageable.getPageSize(),
				primeiroRegistroPagina = paginaAtual * totalRegistroPagina;
		query.setFirstResult(primeiroRegistroPagina);
		query.setMaxResults(totalRegistroPagina);
	}

	private Predicate[] criarRestricoes(OrdemFilter ordemFilter, CriteriaBuilder builder,
			Root<Ordem> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(ordemFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")),
					"%" + ordemFilter.getDescricao().toLowerCase() + "%"));
		}

		if (ordemFilter.getDataSolicitacao() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("dataSolicitacao"), ordemFilter.getDataSolicitacao()));
		}

		if (ordemFilter.getDataFinalizado() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("data"
							+ "Finalizado"), ordemFilter.getDataFinalizado()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
