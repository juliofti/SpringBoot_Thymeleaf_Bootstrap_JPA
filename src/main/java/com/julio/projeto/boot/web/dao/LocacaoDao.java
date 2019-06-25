package com.julio.projeto.boot.web.dao;

import java.util.List;

import com.julio.projeto.boot.web.model.Locacao;

public interface LocacaoDao {
	
		void save(Locacao locacao);

	    void update(Locacao locacao);

	    void delete(Long id);

	    Locacao findById(Long id);

	    List<Locacao> findAll();
	
	
}
