package com.julio.projeto.boot.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.julio.projeto.boot.web.model.Motorista;
import com.julio.projeto.boot.web.service.MotoristaService;

@Controller
@RequestMapping("/motoristas")
public class MotoristaController {
	
	@Autowired
	private MotoristaService service;
	
	@GetMapping("/cadastrar")
	public String retornaPaginaMotorista(Motorista motorista) {
		return "/motorista/crud_motorista";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("motoristas", service.buscarTodos());
		return "/motorista/crud_listar"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Motorista motorista) {
		service.salvar(motorista);
		return "redirect:/motoristas/cadastrar";
	}
}
