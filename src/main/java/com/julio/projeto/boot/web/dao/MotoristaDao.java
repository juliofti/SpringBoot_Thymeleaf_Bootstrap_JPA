package com.julio.projeto.boot.web.dao;

import java.util.List;

import com.julio.projeto.boot.web.model.Motorista;

public interface MotoristaDao {

	 	void save(Motorista motorista);

	    void update(Motorista motorista);

	    void delete(Long id);

	    Motorista findById(Long id);

	    List<Motorista> findAll();
	
}
