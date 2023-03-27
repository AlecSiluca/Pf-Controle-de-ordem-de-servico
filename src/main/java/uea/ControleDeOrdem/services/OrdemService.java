package uea.ControleDeOrdem.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uea.ControleDeOrdem.dto.ResumoOrdemDto;
import uea.ControleDeOrdem.models.Ordem;
import uea.ControleDeOrdem.models.enums.StatusOrdemServico;
import uea.ControleDeOrdem.repositories.OrdemRepository;
import uea.ControleDeOrdem.repositories.filters.OrdemFilter;


@Service
public class OrdemService {
	
	@Autowired
	private OrdemRepository ordemRepository;
	
	public Page<ResumoOrdemDto> resumir(OrdemFilter ordemFilter,
			Pageable pageable){
		return ordemRepository.filtrar(ordemFilter, pageable);
	}
	

	public Ordem criar(Ordem ordem) {
		return ordemRepository.save(ordem);
	}

	public List<Ordem> listar() {
		return ordemRepository.findAll();
	}

	public Ordem buscarPorCodigo(Long codigo) {
		Ordem ordem = ordemRepository.findById(codigo).orElseThrow();
		return ordem;
	}

	public void excluir(Long codigo) {
		ordemRepository.deleteById(codigo);
	}

	public Ordem atualizar(Long codigo, Ordem ordem) {
		Ordem ordemSalva = ordemRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(ordem, ordemSalva, "codigo");
		return ordemRepository.save(ordemSalva);
	}
	
	public Ordem atualizarStatus(Long codigo,
			StatusOrdemServico status) {
		Ordem ordemSalva = ordemRepository.findById(codigo).orElseThrow();
		ordemSalva.setStatus(status);
		return ordemRepository.save(ordemSalva);
	}
	
}

