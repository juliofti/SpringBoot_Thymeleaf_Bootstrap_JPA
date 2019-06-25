package com.julio.projeto.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.julio.projeto.boot.web.model.Cacamba;
import com.julio.projeto.boot.web.service.CacambaService;


@Controller
@RequestMapping("/cacambas")
public class CacambaController {
	
	@Autowired
	private CacambaService service;

	@GetMapping("/cadastrar")
	public String retornaPaginaCacamba(Cacamba cacamba) {
		return "/cacamba/crud_cacamba";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cacambas", service.buscarTodos());
		return "/cacamba/crud_listar"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Cacamba cacamba) {
		service.salvar(cacamba);
		return "redirect:/cacambas/cadastrar"; 
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Caçamba excluída com sucesso.");
		return listar(model);
	}
	
}
