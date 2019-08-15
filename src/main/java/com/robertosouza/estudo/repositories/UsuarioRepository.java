package com.robertosouza.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.robertosouza.estudo.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value="Select u from Usuario u where u.email=:pemail ")
	public Usuario buscarPorEmail(@Param("pemail") String email);

}
