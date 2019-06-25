package com.julio.projeto.boot.web.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "VEICULOS")
public class Veiculo extends AbstractEntity<Long> {

	@NotBlank(message = "Informe o modelo do veiculo.")
	@Size(min = 2, max = 30, message = "O modelo deve ter entre {min} e {max} caracteres.")
	@Column(name = "modelo", nullable = false,length = 60)
	private String modelo;
	
	@NotBlank(message = "Informe a placa do veiculo.")
	@Size(min = 8, message = "A Placa deve ter entre {min} caracteres.")
	@Column(name = "placa", nullable = false,length = 8)
	private String placa;
	
	@OneToMany(mappedBy = "veiculo_entrega")
	private List<Locacao> list_veic_entreg;

	@OneToMany(mappedBy = "veiculo_retira")
	private List<Locacao> list_veic_retira;
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Locacao> getList_veic_entreg() {
		return list_veic_entreg;
	}

	public void setList_veic_entreg(List<Locacao> list_veic_entreg) {
		this.list_veic_entreg = list_veic_entreg;
	}

	public List<Locacao> getList_veic_retira() {
		return list_veic_retira;
	}

	public void setList_veic_retira(List<Locacao> list_veic_retira) {
		this.list_veic_retira = list_veic_retira;
	}

	
	
	
}
