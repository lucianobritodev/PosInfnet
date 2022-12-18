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

import br.com.infnet.locadoraveiculos.domain.entities.Carreta;
import br.com.infnet.locadoraveiculos.domain.entities.enuns.Combustivel;
import br.com.infnet.locadoraveiculos.domain.service.CarretaService;

@Controller
@RequestMapping("/carreta")
public class CarretaController {
	
	@Autowired
	private CarretaService carretaService;
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/carreta/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", carretaService.obterTodos());
		return new ModelAndView("/carreta/listar");
	}
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView telaCadastro(Model model) {
		model.addAttribute("carreta", new Carreta());
		model.addAttribute("combustivelLista", Combustivel.values());
		return new ModelAndView("/carreta/cadastrar");
	}
	
	@GetMapping(value = "/{id}/editar")
	public ModelAndView editar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("carreta", carretaService.obterUm(id));
		model.addAttribute("combustivelLista", Combustivel.values());
		return new ModelAndView("/carreta/cadastrar");
	}
	
	@PostMapping(value = "/salvar")
	public ModelAndView salvar(Model model, @ModelAttribute("carreta") Carreta carreta) {
		boolean incluir = carreta.getId() == null ? true : false;
		carreta = carretaService.salvar(carreta);
		
		String mensagem = incluir ? "Carreta "+ carreta.getId() +" incluido com sucesso!" : "Carreta "+ carreta.getId() +" alterado com sucesso!";
		model.addAttribute("msgSuccess", mensagem);
		return this.telaLista(model);
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		carretaService.excluir(id);
		model.addAttribute("msgSuccess", "Carreta "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
}
