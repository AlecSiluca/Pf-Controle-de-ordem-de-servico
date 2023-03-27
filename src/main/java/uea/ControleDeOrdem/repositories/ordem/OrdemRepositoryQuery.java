package uea.ControleDeOrdem.repositories.ordem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uea.ControleDeOrdem.dto.ResumoOrdemDto;
import uea.ControleDeOrdem.repositories.filters.OrdemFilter;

public interface OrdemRepositoryQuery {
	public Page<ResumoOrdemDto> filtrar(OrdemFilter ordemFilter,Pageable pageable);

}
