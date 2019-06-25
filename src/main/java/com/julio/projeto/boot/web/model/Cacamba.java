package com.julio.projeto.boot.web.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;


@SuppressWarnings("serial")
@Entity
@Table(name = "CACAMBAS")
public class Cacamba extends AbstractEntity<Long> {
	
	@NotBlank(message = "Informe a descricao.")
	@Size(min = 2, max = 25, message = "A descricao da Cacamba deve ter entre {min} e {max} caracteres.")
	@Column(name = "descricao", nullable = false, unique = true, length = 60)
	private String descricao;
	
	@NotNull
	@Column(nullable = false)
	private int capacidade;
	
	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valorlocacao;
	
	@OneToMany(mappedBy = "cacamba")
	private List<Locacao> list_locacao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public BigDecimal getValorlocacao() {
		return valorlocacao;
	}

	public void setValorlocacao(BigDecimal valorlocacao) {
		this.valorlocacao = valorlocacao;
	}

	public List<Locacao> getList_locacao() {
		return list_locacao;
	}

	public void setList_locacao(List<Locacao> list_locacao) {
		this.list_locacao = list_locacao;
	}
	

}
