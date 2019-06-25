package com.julio.projeto.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.julio.projeto.boot.web.dao.CacambaDao;
import com.julio.projeto.boot.web.model.Cacamba;


@Service
@Transactional(readOnly = false)
public class CacambaServiceImpl implements CacambaService{

	
	@Autowired
	private CacambaDao dao;
	
	@Override
	public void salvar(Cacamba cacamba) {
		dao.save(cacamba);
	}

	@Override
	public void editar(Cacamba cacamba) {
		dao.update(cacamba);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cacamba buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cacamba> buscarTodos() {
		return dao.findAll();
	}
}
