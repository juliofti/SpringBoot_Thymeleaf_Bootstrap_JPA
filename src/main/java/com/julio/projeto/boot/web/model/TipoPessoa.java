package com.julio.projeto.boot.web.model;

public enum TipoPessoa {

	PF("PF","PESSOA FISICA"),
	PJ("PJ","PESSOA JURIDICA");
	
	private String sigla;
	private String descricao;
	
	
	 TipoPessoa(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}
	 	 
	
}
