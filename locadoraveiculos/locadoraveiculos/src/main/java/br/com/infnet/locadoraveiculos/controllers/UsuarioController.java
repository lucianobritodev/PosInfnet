package br.com.infnet.locadoraveiculos.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.domain.entities.Endereco;
import br.com.infnet.locadoraveiculos.domain.entities.Usuario;
import br.com.infnet.locadoraveiculos.domain.service.UsuarioService;

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
	

	@PostMapping(value = "/cep")
	public ModelAndView obterCep(@RequestParam(value = "idUsuario", required = false) Long idUsuario, @ModelAttribute("usuario") Usuario usuario, Model model) {
		String cep = usuario.getEndereco().getCepPesquisa();

		if(idUsuario != null) {
			usuario = usuarioService.obterUmPorId(idUsuario);
		}

		Endereco endereco = usuarioService.obterEnderecoPorCep(cep);

		if(usuario.getEndereco() != null && usuario.getEndereco().getId() != null) {
			endereco.setId(usuario.getEndereco().getId());
		}

		usuario.setEndereco(endereco);
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/usuario/cadastrar");
	}
	
	@GetMapping(value = "/cadastrar")
	public ModelAndView telaCadastro(Model model) {
		model.addAttribute("usuario", new Usuario(new Endereco()));
		return new ModelAndView("/usuario/cadastrar");
	}
	
	@GetMapping(value = "/{id}/editar")
	public ModelAndView telaEditar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("usuario", usuarioService.obterUmPorId(id));
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
