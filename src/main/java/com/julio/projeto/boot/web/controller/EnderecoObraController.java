package com.julio.projeto.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.julio.projeto.boot.web.model.Cliente;
import com.julio.projeto.boot.web.model.EnderecoObra;
import com.julio.projeto.boot.web.service.ClienteService;
import com.julio.projeto.boot.web.service.EnderecoObraService;

@Controller
@RequestMapping("/enderecos_obra")
public class EnderecoObraController {

	
	@Autowired
	private EnderecoObraService serviceEndereco;
	@Autowired
	private ClienteService serviceCliente;
	
	@GetMapping("/cadastrar")
	public String retornaPaginaEnderecoObra(EnderecoObra enderecoObra) {
		return "/endereco_obra/crud_endereco";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("enderecos", serviceEndereco.buscarTodos());
		return "/endereco_obra/crud_listar"; 
	}
	
	
	@PostMapping("/salvar")
	public String salvar(EnderecoObra enderecoObra) {
		serviceEndereco.salvar(enderecoObra);
		return "redirect:/enderecos_obra/cadastrar"; 
	}
	
	
	@ModelAttribute("cliente_end")
	public List<Cliente> listaDeClientes() {
		return serviceCliente.buscarTodos();
	}	
}
