package com.robertosouza.estudo.resources;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertosouza.estudo.domain.Loja;
import com.robertosouza.estudo.services.LojaService;

@RestController
@RequestMapping(value="/admin/lojas")
public class LojaResource {
	
	@Autowired
	private LojaService lojaService;
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loja> cadastrarLoja(@RequestBody Loja loja){
		
		Loja loj = lojaService.cadastroLoja(loja);
		return new ResponseEntity<>(loj, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Loja>> buscarLoja(){
		
		Collection<Loja> loja = lojaService.buscaLoja();
		return new ResponseEntity<>(loja, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loja> buscarLojaId(@PathVariable Integer id){
		
		Loja loja = lojaService.buscaLojaId(id);
	return new ResponseEntity<>(loja,HttpStatus.OK);

	}

	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loja> editarLoja(@RequestBody Loja loja){
		
		Loja lj = lojaService.editaLoja(loja);
		return new ResponseEntity<>(lj, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Loja> excluirLoja(@PathVariable Integer id){
		
		Loja lj = lojaService.buscaLojaId(id);
		if (lj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		lojaService.excluiLoja(lj);
		return new ResponseEntity<>(HttpStatus.OK);
		
		
		
	}
	
	

}
