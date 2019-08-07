package com.robertosouza.estudo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robertosouza.estudo.services.LojaService;

@RestController
@RequestMapping(value="/lojas")
public class LojaResource {
	
	@Autowired
	private LojaService lojaService;
	

}
