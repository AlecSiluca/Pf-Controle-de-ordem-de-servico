package uea.ControleDeOrdem.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import uea.ControleDeOrdem.models.enums.StatusOrdemServico;

@Entity
public class Ordem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;
	//@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;
	private LocalDate dataSolicitacao;
	private LocalDate dataFinalizado;
	private String servicoRealizado;
	
	public Ordem() {
		super();
	}

	public Ordem(Long codigo, String descricao, StatusOrdemServico status, LocalDate dataSolicitacao,
			LocalDate dataFinalizado, String servicoRealizado) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.status = status;
		this.dataSolicitacao = dataSolicitacao;
		this.dataFinalizado = dataFinalizado;
		this.servicoRealizado = servicoRealizado;
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo, dataFinalizado, dataSolicitacao, descricao, servicoRealizado, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordem other = (Ordem) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(dataFinalizado, other.dataFinalizado)
				&& Objects.equals(dataSolicitacao, other.dataSolicitacao) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(servicoRealizado, other.servicoRealizado) && status == other.status;
	}
	
	
	

}
