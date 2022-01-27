package com.accountfy.livros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountfy.livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	List<Livro> findByTituloContaining(String titulo);
}
