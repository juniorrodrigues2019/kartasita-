package com.kartasista.kartasista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kartasista.kartasista.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
	

}
