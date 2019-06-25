package com.julio.projeto.boot.web.dao;

import java.util.List;

import com.julio.projeto.boot.web.model.Cacamba;

public interface CacambaDao {
	
		void save(Cacamba cacamba);

	    void update(Cacamba cacamba);

	    void delete(Long id);

	    Cacamba findById(Long id);

	    List<Cacamba> findAll();
	
	
}
