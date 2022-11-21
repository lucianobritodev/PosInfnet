package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.domain.Carro;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculos.model.service.CarroService;

@Controller
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/carro/listar";
	}

	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", carroService.obterTodos());
		return new ModelAndView("/carro/listar");
	}
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView telaCadastro(Model model) {
		model.addAttribute("carro", new Carro());
		model.addAttribute("combustivelLista", Combustivel.values());
		return new ModelAndView("/carro/cadastrar");
	}
	
	@GetMapping(value = "/{id}/editar")
	public ModelAndView editar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("carro", carroService.obterUm(id));
		model.addAttribute("combustivelLista", Combustivel.values());
		return new ModelAndView("/carro/cadastrar");
	}
	
	@PostMapping(value = "/salvar")
	public ModelAndView salvar(Model model, @ModelAttribute("carro") Carro carro) {
		boolean incluir = carro.getId() == null ? true : false;
		carro = carroService.salvar(carro);
		
		String mensagem = incluir ? "Carro "+ carro.getId() +" incluido com sucesso!" : "Carro "+ carro.getId() +" alterado com sucesso!";
		model.addAttribute("msgSuccess", mensagem);
		return this.telaLista(model);
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		carroService.excluir(id);
		model.addAttribute("msgSuccess", "Carro "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}

}
