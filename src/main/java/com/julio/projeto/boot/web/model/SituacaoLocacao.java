package com.julio.projeto.boot.web.model;

public enum SituacaoLocacao {

	ENTREGUE("ENTREGUE"),
	PENDENTE("PENDENTE"),
	RETIRADO("RETIRADO"),
	FALTA_RETIRAR("FALTA_RETIRAR");
	
	private String descricao;
	
	SituacaoLocacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
