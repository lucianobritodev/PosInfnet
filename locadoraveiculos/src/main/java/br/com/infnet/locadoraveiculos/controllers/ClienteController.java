package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.domain.Cliente;
import br.com.infnet.locadoraveiculos.model.domain.Usuario;
import br.com.infnet.locadoraveiculos.model.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", clienteService.obterTodos());
		return new ModelAndView("/cliente/listar");
	}
	
	@GetMapping(value = "/cadastrar")
	public String cadastrar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/cadastrar";
	}
	
	@GetMapping(value = "/{id}/editar")
	public ModelAndView editar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("cliente", clienteService.obterUm(id));
		return new ModelAndView("/cliente/cadastrar");
	}

	// @SessionAttribute("user") Usuario usuario
	@PostMapping(value = "/incluir")
	public ModelAndView incluir(Model model, @ModelAttribute("cliente") Cliente cliente, @SessionAttribute("user") Usuario usuario) {
		boolean incluir = cliente.getId() == null ? true : false;
		//cliente.setUsuario(usuario);
		cliente = clienteService.incluir(cliente);
		
		if(incluir) {			
			model.addAttribute("msgSuccess", "Usuario "+ cliente.getId() +" incluido com sucesso!");
		} else {
			model.addAttribute("msgSuccess", "Usuario "+ cliente.getId() +" alterado com sucesso!");
		}
		
		return this.telaLista(model);
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		clienteService.excluir(id);
		model.addAttribute("msgSuccess", "Cliente "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
}
