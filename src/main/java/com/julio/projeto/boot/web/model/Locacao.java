package com.julio.projeto.boot.web.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;



@SuppressWarnings("serial")
@Entity
@Table(name = "Locacao")
public class Locacao extends AbstractEntity<Long> {
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_Entrega", columnDefinition = "DATE")
	private LocalDate dataEntrega;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_Retira", columnDefinition = "DATE")
	private LocalDate dataRetira;
	
	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal preco_locacao;
	
	@NotNull(message = "{NotNull.endereco.uf}")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SituacaoLocacao situacao_locacao;
	
	@NotNull(message = "{NotNull.endereco.uf}")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private  SituacaoPagamento situacao_pag;
		
	@ManyToOne
	@JoinColumn(name = "id_enderecoObra_fk")
	private EnderecoObra enderecoObra;
	
	@ManyToOne
	@JoinColumn(name = "id_cacamba_fk")
	private Cacamba cacamba;
	
	@ManyToOne
	@JoinColumn(name = "id_motorista_entrega_fk")
	private Motorista motorista_entrega;
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo_entrega_fk")
	private Veiculo veiculo_entrega;
	
	@ManyToOne
	@JoinColumn(name = "id_motorista_retira_fk")
	private Motorista motorista_retira;
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo_retira_fk")
	private Veiculo veiculo_retira;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;
	
	
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataRetira() {
		return dataRetira;
	}

	public void setDataRetira(LocalDate dataRetira) {
		this.dataRetira = dataRetira;
	}

	public BigDecimal getPreco_locacao() {
		return preco_locacao;
	}

	public void setPreco_locacao(BigDecimal preco_locacao) {
		this.preco_locacao = preco_locacao;
	}

	public SituacaoLocacao getSituacao_locacao() {
		return situacao_locacao;
	}

	public void setSituacao_locacao(SituacaoLocacao situacao_locacao) {
		this.situacao_locacao = situacao_locacao;
	}

	public SituacaoPagamento getSituacao_pag() {
		return situacao_pag;
	}

	public void setSituacao_pag(SituacaoPagamento situacao_pag) {
		this.situacao_pag = situacao_pag;
	}

	public EnderecoObra getEnderecoObra() {
		return enderecoObra;
	}

	public void setEnderecoObra(EnderecoObra enderecoObra) {
		this.enderecoObra = enderecoObra;
	}

	public Cacamba getCacamba() {
		return cacamba;
	}

	public void setCacamba(Cacamba cacamba) {
		this.cacamba = cacamba;
	}

	public Motorista getMotorista_entrega() {
		return motorista_entrega;
	}

	public void setMotorista_entrega(Motorista motorista_entrega) {
		this.motorista_entrega = motorista_entrega;
	}

	public Veiculo getVeiculo_entrega() {
		return veiculo_entrega;
	}

	public void setVeiculo_entrega(Veiculo veiculo_entrega) {
		this.veiculo_entrega = veiculo_entrega;
	}

	public Motorista getMotorista_retira() {
		return motorista_retira;
	}

	public void setMotorista_retira(Motorista motorista_retira) {
		this.motorista_retira = motorista_retira;
	}

	public Veiculo getVeiculo_retira() {
		return veiculo_retira;
	}

	public void setVeiculo_retira(Veiculo veiculo_retira) {
		this.veiculo_retira = veiculo_retira;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
