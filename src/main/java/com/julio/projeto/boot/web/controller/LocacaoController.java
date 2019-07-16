package com.julio.projeto.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.julio.projeto.boot.web.model.Cacamba;
import com.julio.projeto.boot.web.model.Cliente;
import com.julio.projeto.boot.web.model.EnderecoObra;
import com.julio.projeto.boot.web.model.Locacao;
import com.julio.projeto.boot.web.model.Motorista;
import com.julio.projeto.boot.web.model.SituacaoLocacao;
import com.julio.projeto.boot.web.model.SituacaoPagamento;
import com.julio.projeto.boot.web.model.Veiculo;
import com.julio.projeto.boot.web.service.CacambaService;
import com.julio.projeto.boot.web.service.ClienteService;
import com.julio.projeto.boot.web.service.EnderecoObraService;
import com.julio.projeto.boot.web.service.LocacaoService;
import com.julio.projeto.boot.web.service.MotoristaService;
import com.julio.projeto.boot.web.service.VeiculoService;

@Controller
@RequestMapping("/locacaos")
public class LocacaoController {
	
	@Autowired
	LocacaoService locacaoService;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	EnderecoObraService enderecoService;
	
	@Autowired
	CacambaService cacambaService;
	
	@Autowired
	MotoristaService motoristaService;
	
	@Autowired
	VeiculoService veiculoService;
	
	@GetMapping("/cadastrar")
	public String retornaPaginaLocacao(Locacao locacao) {
		return "locacao/crud_locacao";
	}
	
	@PostMapping("/salvar")
	public String salvar(Locacao locacao) {
		locacaoService.salvar(locacao);
		return "redirect:/locacaos/cadastrar";
	}
	
	@ModelAttribute("clientes")
	public List<Cliente> getCliente() {
		return clienteService.buscarTodos();
	}
	
	
	@ModelAttribute("cacambas")
	public List<Cacamba> getCacambas(){
		return cacambaService.buscarTodos();
	}
	
	@ModelAttribute("veiculo_entrega")
	public List<Veiculo> getVeiculos(){
		return veiculoService.buscarTodos();
	}
	
	@ModelAttribute("motorista_entrega")
	public List<Motorista> getMotoristas(){
		return motoristaService.buscarTodos();
	}
	
	
	@GetMapping("/preencherCPF/{id}")
	public @ResponseBody String getPreecherCPF(@PathVariable("id") Long id, ModelMap model) {	
		return clienteService.buscarPorId(id).getCnpj_cpf();
	}
	
	
	//@GetMapping("/preencherCombEnd/{id}")
	@RequestMapping(path = "/preencherCombEnd/{id}", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<EnderecoObra> getBuscarEndCliente(@PathVariable("id") Long id, ModelMap model){
	        return enderecoService.buscarPorEndereco(id);
	    }
	
	@ModelAttribute("situacao_pag")
	public SituacaoPagamento[] getStatusPag() {
		return SituacaoPagamento.values();
	}
	
	@ModelAttribute("situacao_locacao")
	public SituacaoLocacao[] getSituacao() {
		return SituacaoLocacao.values();
	}

}
