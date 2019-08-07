package com.robertosouza.estudo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertosouza.estudo.domain.Usuario;
import com.robertosouza.estudo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usu) {
		
		return usuarioRepository.save(usu);
		
	}
	
	public Usuario alterar(Usuario usu) {
		return usuarioRepository.save(usu);
	}

}
