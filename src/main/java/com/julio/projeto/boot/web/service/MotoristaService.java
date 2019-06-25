package com.julio.projeto.boot.web.service;

import java.util.List;

import com.julio.projeto.boot.web.model.Motorista;

public interface MotoristaService {

	void salvar(Motorista motorista);
	
	void editar(Motorista motorista);
	
	void excluir(Long id);
	
	Motorista buscarPorId(Long id);
	
	List<Motorista> buscarTodos();
	
}
