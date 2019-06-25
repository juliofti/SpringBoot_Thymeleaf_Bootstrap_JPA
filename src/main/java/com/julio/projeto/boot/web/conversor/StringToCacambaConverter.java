package com.julio.projeto.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.julio.projeto.boot.web.model.Cacamba;
import com.julio.projeto.boot.web.service.CacambaService;

public class StringToCacambaConverter implements Converter<String, Cacamba>{

	@Autowired
	private CacambaService service;
	
	@Override
	public Cacamba convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
