package com.julio.projeto.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julio.projeto.boot.web.dao.ClienteDao;
import com.julio.projeto.boot.web.model.Cliente;

@Service
@Transactional(readOnly = false)
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDao dao;
	
	@Override
	public void salvar(Cliente cliente) {
		dao.save(cliente);
	}

	@Override
	public void editar(Cliente cliente) {
		dao.update(cliente);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		return dao.findById(id); 
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {
		return dao.findAll();
	}
	
	@Override
	public List<Cliente> buscarPorNome(String nome) {
		
		return dao.findByNome(nome);
	}
	
	@Override
	public List<Cliente> buscarPorCpf(String cpf_cnpj) {
		
		return dao.findByNome(cpf_cnpj);
	}

}
