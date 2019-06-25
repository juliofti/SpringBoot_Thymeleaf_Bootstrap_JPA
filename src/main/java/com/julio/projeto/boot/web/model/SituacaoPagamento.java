package com.julio.projeto.boot.web.model;

public enum SituacaoPagamento {

	PG("PG", "PAGO"), 
	NPGO("NPGO", "NÃO-PAGO");
	
	private String sigla;
	private String descricao;
	
	SituacaoPagamento(String sigla, String descricao) {
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
