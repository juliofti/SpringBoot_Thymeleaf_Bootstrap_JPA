package com.julio.projeto.boot.web.service;

import java.util.List;

import com.julio.projeto.boot.web.model.Cliente;

public interface ClienteService {
	
	void salvar(Cliente cliente);
	
	void editar(Cliente cliente);
	
	void excluir(Long id);
	
	Cliente buscarPorId(Long id);
	
	List<Cliente> buscarTodos();
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscarPorCpf(String cnpj_cpf);
}
