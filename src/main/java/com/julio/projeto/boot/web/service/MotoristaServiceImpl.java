package com.julio.projeto.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julio.projeto.boot.web.dao.MotoristaDao;
import com.julio.projeto.boot.web.model.Motorista;

@Service
@Transactional(readOnly = false)
public class MotoristaServiceImpl implements MotoristaService{

	
	@Autowired
	private MotoristaDao dao;
	
	@Override
	public void salvar(Motorista motorista) {
		dao.save(motorista);
	}

	@Override
	public void editar(Motorista motorista) {
		dao.update(motorista);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Motorista buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Motorista> buscarTodos() {
		return dao.findAll();
	}

}
