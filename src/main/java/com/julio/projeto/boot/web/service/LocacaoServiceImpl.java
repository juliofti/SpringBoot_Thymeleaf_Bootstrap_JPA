package com.julio.projeto.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julio.projeto.boot.web.dao.LocacaoDao;
import com.julio.projeto.boot.web.model.Locacao;


@Service
@Transactional(readOnly = false)
public class LocacaoServiceImpl implements LocacaoService{

	
	@Autowired
	private LocacaoDao dao;
	
	@Override
	public void salvar(Locacao locacao) {
		dao.save(locacao);
	}

	@Override
	public void editar(Locacao locacao) {
		dao.update(locacao);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Locacao buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Locacao> buscarTodos() {
		return dao.findAll();
	}
}
