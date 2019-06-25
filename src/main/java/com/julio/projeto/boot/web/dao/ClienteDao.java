package com.julio.projeto.boot.web.dao;

import java.util.List;

import com.julio.projeto.boot.web.model.Cliente;

public interface ClienteDao {

	 void save(Cliente cliente);

	    void update(Cliente cliente);

	    void delete(Long id);

	    Cliente findById(Long id);

	    List<Cliente> findAll();
	    
	    List<Cliente> findByNome(String nome);
	    
	    List<Cliente> findByCPF(String cpf_cnpj);
}
