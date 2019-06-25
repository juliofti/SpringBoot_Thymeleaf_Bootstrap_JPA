package com.julio.projeto.boot.web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonBackReference;


@SuppressWarnings("serial")
@Entity
@Table(name = "CLIENTES")
public class Cliente extends AbstractEntity<Long>{

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String st_nome_cliente;
	
	@NotBlank
	@Size(max = 200, min = 3)
	@Column(nullable = false, unique = true)
	private String st_email_cliente;
	
	@NotBlank(message = "O numero do cliente e obrigatório.")
	@NumberFormat(style = Style.CURRENCY, pattern = "(##)#####-####")
	@Column(name = "numero_telefone", nullable = false, unique = true, length = 14)
	private String numero_telefone;
	
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipopessoa;
	
	
	//O cascade significa que quando for inserido um cliente será inserido um endereco por cascata.
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	@NotBlank
	@Size(min = 11, max = 19)
	@Column(nullable = false)
	private String cnpj_cpf;
	
	@JsonBackReference
	@OneToMany(mappedBy = "cliente_end")
	private List<EnderecoObra> list_enderecoObra;
	
	@OneToMany(mappedBy = "cliente")
	private List<Locacao> list_locacao;
	

	public String getSt_nome_cliente() {
		return st_nome_cliente;
	}

	public void setSt_nome_cliente(String st_nome_cliente) {
		this.st_nome_cliente = st_nome_cliente;
	}

	public String getSt_email_cliente() {
		return st_email_cliente;
	}

	public void setSt_email_cliente(String st_email_cliente) {
		this.st_email_cliente = st_email_cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCnpj_cpf() {
		return cnpj_cpf;
	}

	public void setCnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}

	public String getNumero_telefone() {
		return numero_telefone;
	}

	public void setNumero_telefone(String numero_telefone) {
		this.numero_telefone = numero_telefone;
	}

	public TipoPessoa getTipopessoa() {
		return tipopessoa;
	}

	public void setTipopessoa(TipoPessoa tipopessoa) {
		this.tipopessoa = tipopessoa;
	}

	public List<EnderecoObra> getList_enderecoObra() {
		return list_enderecoObra;
	}

	public void setList_enderecoObra(List<EnderecoObra> list_enderecoObra) {
		this.list_enderecoObra = list_enderecoObra;
	}

	public List<Locacao> getList_locacao() {
		return list_locacao;
	}

	public void setList_locacao(List<Locacao> list_locacao) {
		this.list_locacao = list_locacao;
	}

	
	

}
