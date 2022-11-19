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

import br.com.infnet.locadoraveiculos.model.domain.Trator;
import br.com.infnet.locadoraveiculos.model.domain.enuns.Combustivel;
import br.com.infnet.locadoraveiculos.model.domain.enuns.TipoTrator;
import br.com.infnet.locadoraveiculos.model.service.TratorService;

@Controller
@RequestMapping("/trator")
public class TratorController {
	
	@Autowired
	private TratorService tratorService;

	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/trator/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", tratorService.obterTodos());
		return new ModelAndView("/trator/listar");
	}
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView telaCadastro(Model model) {
		model.addAttribute("trator", new Trator());
		model.addAttribute("combustivelLista", Combustivel.values());
		model.addAttribute("tratorLista", TipoTrator.values());
		return new ModelAndView("/trator/cadastrar");
	}
	
	@GetMapping(value = "/{id}/editar")
	public ModelAndView editar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("trator", tratorService.obterUmPorId(id));
		model.addAttribute("combustivelLista", Combustivel.values());
		model.addAttribute("tratorLista", TipoTrator.values());
		return new ModelAndView("/trator/cadastrar");
	}
	
	@PostMapping(value = "/salvar")
	public ModelAndView salvar(Model model, @ModelAttribute("trator") Trator trator) {
		boolean incluir = trator.getId() == null ? true : false;
		trator = tratorService.salvar(trator);
		
		if(incluir) {			
			model.addAttribute("msgSuccess", "Trator "+ trator.getId() +" incluido com sucesso!");
		} else {
			model.addAttribute("msgSuccess", "Trator "+ trator.getId() +" alterado com sucesso!");
		}
		
		return this.telaLista(model);
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		tratorService.excluir(id);
		model.addAttribute("msgSuccess", "Trator "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
}
