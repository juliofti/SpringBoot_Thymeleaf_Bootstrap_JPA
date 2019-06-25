package com.julio.projeto.boot.web.service;

import java.util.List;
import com.julio.projeto.boot.web.model.Locacao;

public interface LocacaoService {

	void salvar(Locacao locacao);
	
	void editar(Locacao locacao);
	
	void excluir(Long id);
	
	Locacao buscarPorId(Long id);
	
	List<Locacao> buscarTodos();
	
}
