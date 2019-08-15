package com.robertosouza.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.robertosouza.estudo.resources.TokenFilter;


@SpringBootApplication
public class EstudoApplication {
	
	@Bean
	public FilterRegistrationBean filtroJwt(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin/*");
		return frb;
	}

	public static void main(String[] args) {
		SpringApplication.run(EstudoApplication.class, args);
	}

}
