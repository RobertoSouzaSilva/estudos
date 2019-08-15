package com.robertosouza.estudo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertosouza.estudo.domain.Usuario;
import com.robertosouza.estudo.services.UsuarioService;

@RestController
public class UsuAutResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/usuaut", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario) {
		
		Usuario usuAut = usuarioService.buscarPorEmail(usuario.getEmail());
		return new ResponseEntity<Usuario>(usuAut, HttpStatus.OK);
	}
	

}
