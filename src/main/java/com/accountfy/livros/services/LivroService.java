package com.accountfy.livros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountfy.livros.entities.Livro;
import com.accountfy.livros.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository repository;
	
	public List<Livro> findAll(){
		return repository.findAll();
	}
	
	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Long count(){
		return repository.count();
	}
}
