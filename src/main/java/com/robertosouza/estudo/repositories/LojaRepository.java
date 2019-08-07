package com.robertosouza.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robertosouza.estudo.domain.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer>{

}
