package com.robertosouza.estudo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertosouza.estudo.domain.Usuario;
import com.robertosouza.estudo.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Usuario> cadastro(@RequestBody Usuario usuario){
		
		Usuario usu = usuarioService.cadastrar(usuario);
		return new ResponseEntity<>(usu, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario) {

		Usuario usu = usuarioService.alterar(usuario);
		return new ResponseEntity<>(usu, HttpStatus.OK);
	}

}
