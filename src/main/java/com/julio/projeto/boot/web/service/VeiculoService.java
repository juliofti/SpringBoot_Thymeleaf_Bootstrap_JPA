package com.julio.projeto.boot.web.service;

import java.util.List;

import com.julio.projeto.boot.web.model.Veiculo;

public interface VeiculoService {
	void salvar(Veiculo veiculo);
	
	void editar(Veiculo veiculo);
	
	void excluir(Long id);
	
	Veiculo buscarPorId(Long id);
	
	List<Veiculo> buscarTodos();
}
