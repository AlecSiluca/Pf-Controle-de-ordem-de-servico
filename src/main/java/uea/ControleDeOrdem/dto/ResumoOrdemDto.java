package uea.ControleDeOrdem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import uea.ControleDeOrdem.models.enums.StatusOrdemServico;

public class ResumoOrdemDto {

	private Long codigo;
	private String descricao;
	private StatusOrdemServico status;
	private LocalDate dataSolicitacao;
	private LocalDate dataFinalizado;
	private String servicoRealizado;

	public ResumoOrdemDto(Long codigo, String descricao, StatusOrdemServico status, LocalDate dataSolicitacao,
			LocalDate dataFinalizado, String servicoRealizado) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.status = status;
		this.dataSolicitacao = dataSolicitacao;
		this.dataFinalizado = dataFinalizado;
		this.servicoRealizado = servicoRealizado;
	}

	public ResumoOrdemDto() {
		super();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
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

	public String getServicoRealizado() {
		return servicoRealizado;
	}

	public void setServicoRealizado(String servicoRealizado) {
		this.servicoRealizado = servicoRealizado;
	}

}
