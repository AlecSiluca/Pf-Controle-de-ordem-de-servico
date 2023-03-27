package uea.ControleDeOrdem.repositories.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class OrdemFilter {	
	
	private String descricao;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataSolicitacao;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataFinalizado;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public LocalDate getDataFinalizado() {
		return dataFinalizado;
	}
	public void setDataFinalizado(LocalDate dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}
	
	

}
