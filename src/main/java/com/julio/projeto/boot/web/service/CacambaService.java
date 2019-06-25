package com.julio.projeto.boot.web.service;

import java.util.List;
import com.julio.projeto.boot.web.model.Cacamba;

public interface CacambaService {

	void salvar(Cacamba cacamba);
	
	void editar(Cacamba cacamba);
	
	void excluir(Long id);
	
	Cacamba buscarPorId(Long id);
	
	List<Cacamba> buscarTodos();
	
}
