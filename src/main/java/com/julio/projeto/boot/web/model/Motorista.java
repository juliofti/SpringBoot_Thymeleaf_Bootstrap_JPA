package com.julio.projeto.boot.web.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "MOTORISTAS")
public class Motorista extends AbstractEntity<Long>{

	
	@NotBlank(message = "Informe um nome.")
	@Size(min = 2, max = 100, message = "O nome do Motorista deve ter entre {min} e {max} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotBlank
	@Size(min = 11, max = 18)
	@Column(nullable = false)
	private String cpf;
	
	@OneToMany(mappedBy = "motorista_entrega")
	private List<Locacao> list_mot_entreg;
	
	@OneToMany(mappedBy = "motorista_retira")
	private List<Locacao> list_mot_retir;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Locacao> getList_mot_entreg() {
		return list_mot_entreg;
	}

	public void setList_mot_entreg(List<Locacao> list_mot_entreg) {
		this.list_mot_entreg = list_mot_entreg;
	}

	public List<Locacao> getList_mot_retir() {
		return list_mot_retir;
	}

	public void setList_mot_retir(List<Locacao> list_mot_retir) {
		this.list_mot_retir = list_mot_retir;
	}
	
	

	
	
	
}
