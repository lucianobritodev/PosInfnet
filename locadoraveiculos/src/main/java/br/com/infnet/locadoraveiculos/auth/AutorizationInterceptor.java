package br.com.infnet.locadoraveiculos.auth;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.infnet.locadoraveiculos.model.domain.Usuario;

@Component
public class AutorizationInterceptor implements HandlerInterceptor {
	
	private List<String> rotasPulblicas = Arrays
			.asList("/", "/login", "/logout", "/usuario/cadastrar");

	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute("user");
		
		//TODO adicionar roles
		if(usuario != null) return true;
		
		for(String rota : rotasPulblicas) {
			if(uri.endsWith(rota)) {
				return true;
			}
		}
		
		response.sendRedirect("/login");
		return false;
	}
}
