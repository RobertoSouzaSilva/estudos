package com.robertosouza.estudo.resources;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertosouza.estudo.domain.Usuario;
import com.robertosouza.estudo.services.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginResource {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {

		if (usuario.getEmail() == null || usuario.getSenha() == null) {
			throw new ServletException("Nome e senha obrigatório.");
		}
		
		Usuario usuAutenticado = usuarioService.buscarPorEmail(usuario.getEmail());

		if (usuAutenticado == null) {
			throw new ServletException("Usuário não encontrado.");
		}

		if (!usuAutenticado.getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Usuário ou senha inválido.");
		}

		String token = Jwts.builder().setSubject(usuAutenticado.getEmail())
				.signWith(SignatureAlgorithm.HS512, "Security")
				.setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000)).compact();

		return new LoginResponse(token);
	}

	private class LoginResponse {
		public String token;

		public LoginResponse(String token) {
			this.token = token;
		}

	}

}
