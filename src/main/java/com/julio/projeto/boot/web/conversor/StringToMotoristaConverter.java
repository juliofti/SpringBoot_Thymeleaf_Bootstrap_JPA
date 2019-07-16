package com.julio.projeto.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.julio.projeto.boot.web.model.Motorista;
import com.julio.projeto.boot.web.service.MotoristaService;

@Component
public class StringToMotoristaConverter implements Converter<String, Motorista>{

	@Autowired
	private MotoristaService service;
	
	@Override
	public Motorista convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.parseLong(text);
		return service.buscarPorId(id);
	}

	
}
