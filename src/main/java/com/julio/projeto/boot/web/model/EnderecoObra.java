package com.julio.projeto.boot.web.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECO_OBRA")
public class EnderecoObra extends AbstractEntity<Long> {
	
	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String logradouro;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String cidade;
		
	@NotBlank
	@Size(min = 9, max = 9, message = "{Size.endereco.cep}")
	@Column(nullable = false, length = 9)
	private String cep;
	
	@JsonManagedReference
	@NotNull(message = "Selecione o cliente relativo ao endereco da Obra.")
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente_end;
		
	@OneToMany(mappedBy = "enderecoObra")
	private List<Locacao> locacao;
		
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getCliente_end() {
		return cliente_end;
	}

	public void setCliente_end(Cliente cliente_end) {
		this.cliente_end = cliente_end;
	}

	public List<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(List<Locacao> locacao) {
		this.locacao = locacao;
	}

	
}
