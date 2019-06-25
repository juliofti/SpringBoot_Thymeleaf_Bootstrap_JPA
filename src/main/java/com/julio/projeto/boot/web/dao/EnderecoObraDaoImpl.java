package com.julio.projeto.boot.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.julio.projeto.boot.web.model.EnderecoObra;

@Repository
public class EnderecoObraDaoImpl extends AbstractDao<EnderecoObra, Long> implements EnderecoObraDao{

	@Override
	public List<EnderecoObra> findByEnderecoId(Long id) {
		return createQuery("select e from EnderecoObra e where e.cliente_end.id = ?1", id);
	}

}
