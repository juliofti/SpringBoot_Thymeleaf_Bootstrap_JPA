package com.julio.projeto.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.julio.projeto.boot.web.model.Veiculo;
import com.julio.projeto.boot.web.service.VeiculoService;

@Component
public class StringToVeiculoConverter implements Converter<String, Veiculo>{

	@Autowired
	private VeiculoService service;
	
	@Override
	public Veiculo convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
