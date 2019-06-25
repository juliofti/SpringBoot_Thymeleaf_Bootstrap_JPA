package com.julio.projeto.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.julio.projeto.boot.web.model.Veiculo;
import com.julio.projeto.boot.web.service.VeiculoService;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;
	
	@GetMapping("/cadastrar")
	public String retornaPaginaVeiculo(Veiculo veiculo) {
		return "/veiculo/crud_veiculo";
	} 
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("veiculos", service.buscarTodos());
		return "/veiculo/crud_listar"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Veiculo veiculo, BindingResult result, RedirectAttributes attr) {
		service.salvar(veiculo);
		attr.addFlashAttribute("success", "Veiculo salvo com sucesso.");
		return "redirect:/veiculos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("veiculo", service.buscarPorId(id));
		return "veiculo/crud_veiculo";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attr) {
		service.editar(veiculo);
		attr.addFlashAttribute("success", "Veiculo editado com sucesso.");
		return "redirect:/veiculos/cadastrar";
	}
	

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Veiculo excluído com sucesso.");
		return listar(model);
	}
}
