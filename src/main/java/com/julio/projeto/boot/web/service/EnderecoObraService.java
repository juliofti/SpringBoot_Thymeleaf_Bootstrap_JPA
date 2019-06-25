package com.julio.projeto.boot.web.service;

import java.util.List;

import com.julio.projeto.boot.web.model.EnderecoObra;

public interface EnderecoObraService {

	void salvar(EnderecoObra enderecoObra);
	
	void editar(EnderecoObra enderecoObra);
	
	void excluir(Long id);
	
	EnderecoObra buscarPorId(Long id);
	
	List<EnderecoObra> buscarTodos();

	List<EnderecoObra> buscarPorEndereco(Long id);
	
}
