package com.kartasista.kartasista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kartasista.kartasista.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	

}
