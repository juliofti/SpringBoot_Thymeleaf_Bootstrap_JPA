package com.julio.projeto.boot.web.dao;

import java.util.List;

import com.julio.projeto.boot.web.model.Veiculo;

public interface VeiculoDao {

	void save(Veiculo veiculo);

    void update(Veiculo veiculo);

    void delete(Long id);

    Veiculo findById(Long id);

    List<Veiculo> findAll();
	
}
