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
	
	public List<Livro> obterTodos(){
		return repository.findAll();
	}
	
	public Livro encontrarPeloId(Long id) {
		Optional<Livro> obj = repository.findById(id);
		
		return obj.get();
	}
	
	public Long contarTodos(){
		return repository.count();
	}
	
	public Boolean naoEstaVazio(){
		Long count = repository.count();
		if(count > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean estaVazio(){
		Long count = repository.count();
		if(count > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void salvar(Livro obj) {
		repository.save(obj);
	}
	
	public void excluirPeloId(Long id) {
		repository.deleteById(id);
	}
}
