package com.julio.projeto.boot.web.dao;

import java.util.List;

import com.julio.projeto.boot.web.model.EnderecoObra;

public interface EnderecoObraDao {
	
		void save(EnderecoObra enderecoObra);

	    void update(EnderecoObra enderecoObra);

	    void delete(Long id);

	    EnderecoObra findById(Long id);

	    List<EnderecoObra> findAll();

		List<EnderecoObra> findByEnderecoId(Long id);
	
	
}
