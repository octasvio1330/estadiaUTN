package com.octavio.mancillaco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.octavio.mancillaco.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
