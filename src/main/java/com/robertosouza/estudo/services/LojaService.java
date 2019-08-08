package com.robertosouza.estudo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertosouza.estudo.domain.Loja;
import com.robertosouza.estudo.repositories.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public Loja cadastroLoja(Loja loj) {
		return lojaRepository.save(loj);
	}
	
	public Collection<Loja> buscaLoja() {
		return lojaRepository.findAll();
	}
	
	public Loja editaLoja(Loja lj) {
		return lojaRepository.save(lj);
	}
	
	public Loja buscaLojaId(Integer id) {
		return (Loja) lojaRepository.findById(id).orElse(null);
	}
	
	public void excluiLoja(Loja lja) {
		lojaRepository.delete(lja);
	}

}
