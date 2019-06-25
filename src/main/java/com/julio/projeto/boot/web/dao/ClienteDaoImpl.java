package com.julio.projeto.boot.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.julio.projeto.boot.web.model.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao{
	
public List<Cliente> findByNome(String nome) {
		
		return createQuery("select f from Cliente f where f.st_nome_cliente like concat('%',?1,'%') ", nome);
	}

@Override
public List<Cliente> findByCPF(String cpf_cnpj) {
	
	return createQuery("select f from Cliente f where f.cnpj_cpf like concat('%',?1,'%') ", cpf_cnpj);
}

}
