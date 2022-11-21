package br.com.infnet.locadoraveiculosfront.auth;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.infnet.locadoraveiculosfront.model.domain.Usuario;

@Component
public class AutorizationInterceptor implements HandlerInterceptor {
	
	private List<String> rotasPulblicas = Arrays
			.asList("/", "/login", "/logout", "/usuario/cadastrar", "/usuario/cep", "/usuario/salvar");

	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute("user");
		
		//TODO adicionar roles
		if(usuario != null && !uri.equals("/usuario/cep")) return true;
		
		for(String rota : rotasPulblicas) {
			if(uri.endsWith(rota)) {
				return true;
			}
		}
		
		response.sendRedirect("/login");
		return false;
	}
}
