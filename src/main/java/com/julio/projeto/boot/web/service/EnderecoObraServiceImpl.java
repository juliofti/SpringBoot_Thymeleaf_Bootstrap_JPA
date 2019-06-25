package com.julio.projeto.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julio.projeto.boot.web.dao.EnderecoObraDao;
import com.julio.projeto.boot.web.model.EnderecoObra;


@Service
@Transactional(readOnly = false)
public class EnderecoObraServiceImpl implements EnderecoObraService{

	
	@Autowired
	private EnderecoObraDao dao;
	
	@Override
	public void salvar(EnderecoObra enderecoObra) {
		dao.save(enderecoObra);
	}

	@Override
	public void editar(EnderecoObra enderecoObra) {
		dao.update(enderecoObra);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public EnderecoObra buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EnderecoObra> buscarTodos() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<EnderecoObra> buscarPorEndereco(Long id) {
		return dao.findByEnderecoId(id);
	}
}
