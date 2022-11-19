package br.com.infnet.locadoraveiculos.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.locadoraveiculos.model.domain.Usuario;
import br.com.infnet.locadoraveiculos.model.service.UsuarioService;

@Controller
@SessionAttributes("user")
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String redirectLogin() {
		return "redirect:/login";
	}
	
	@GetMapping(value = "/login")
	public String telaLogin(Model model) {
		return "login";
	}

	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		Usuario usuario = usuarioService.validar(email, senha);

		if(usuario != null) {
			model.addAttribute("user", usuario);
			return "redirect:/home";
		}
		
		model.addAttribute("msgWarning", "Usuario não encontrado!");
		return this.telaLogin(model);
	}

	@GetMapping("/home")
	public ModelAndView telaHome(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("user");
		
		if( usuario != null) {			
			model.addAttribute("msgWelcome", "Seja bem-vindo " + usuario.getNome() +"!");
			return new ModelAndView("/home");
		}
		return new ModelAndView("/login");
	}	
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/login";
	}
	
}
