package com.julio.projeto.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julio.projeto.boot.web.model.Cliente;
import com.julio.projeto.boot.web.model.TipoPessoa;
import com.julio.projeto.boot.web.model.UF;
import com.julio.projeto.boot.web.service.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/cadastrar")
	public String retornaPaginaCliente(Cliente cliente) {
		return "/cliente/crud_cliente";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", service.buscarTodos());
		return "/cliente/crud_listar"; 
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("clientes", service.buscarPorNome(nome));
		return "/cliente/crud_listar";
	}
	
	@GetMapping("/buscar/cpf_cnpj")
	public String getPorCpf(@RequestParam("cpf_cnpj") String cpf_cnpj, ModelMap model) {		
		model.addAttribute("clientes", service.buscarPorCpf(cpf_cnpj));
		return "/cliente/crud_listar";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "cliente/crud_cliente";
		}
		service.salvar(cliente);
		attr.addFlashAttribute("success", "Cliente inserido com sucesso.");
		return  "redirect:/clientes/cadastrar";
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	@ModelAttribute("tipos")
	public TipoPessoa[] getTipoPessoas() {
		return TipoPessoa.values();
	}
	
}
