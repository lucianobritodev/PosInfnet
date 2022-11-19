package br.com.infnet.locadoraveiculos.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.domain.Usuario;
import br.com.infnet.locadoraveiculos.model.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String redirectTelaLista() {
		return "redirect:/usuario/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView telaLista(Model model) {
		model.addAttribute("listagem", usuarioService.obterTodos());
		return new ModelAndView("/usuario/listar");
	}
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView telaCadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return new ModelAndView("/usuario/cadastrar");
	}
	
	@GetMapping(value = "/{id}/editar")
	public ModelAndView telaEditar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("usuario", usuarioService.obterUm(id));
		return new ModelAndView("/usuario/cadastrar");
	}

	@PostMapping(value = "/salvar")
	public ModelAndView salvar(Model model, @ModelAttribute("usuario") Usuario usuario, HttpServletRequest req) {
		boolean incluir = usuario.getId() == null ? true : false;
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		usuario = usuarioService.salvar(usuario);
		
		if(incluir) {
			model.addAttribute("msgSuccess", "Usuario "+ usuario.getNome().split(" ")[0] +" incluido com sucesso!");
			if(user == null) return new ModelAndView("/login");
			return this.telaLista(model);
		}
		
		model.addAttribute("msgSuccess", "Usuario "+ usuario.getNome().split(" ")[0] +" alterado com sucesso!");
		return this.telaLista(model);
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		usuarioService.excluir(id);
		model.addAttribute("msgSuccess", "Usuario "+ id +" excluido com sucesso!");
		return this.telaLista(model);
	}
	
}
