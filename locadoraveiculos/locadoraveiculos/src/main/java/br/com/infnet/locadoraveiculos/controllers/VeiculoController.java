package br.com.infnet.locadoraveiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.domain.Usuario;
import br.com.infnet.locadoraveiculos.model.service.VeiculoService;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;

	@GetMapping
	public String redirectTelaLista() {
		return "redirect:/veiculo/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("listagem", veiculoService.obterTodosPorUsuario(usuario));
		return new ModelAndView("/veiculo/listar");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model, @SessionAttribute("user") Usuario usuario) {
		veiculoService.excluir(id);
		model.addAttribute("msgSuccess", "Veiculo "+ id +" excluido com sucesso!");
		return this.telaLista(model, usuario);
	}
}
