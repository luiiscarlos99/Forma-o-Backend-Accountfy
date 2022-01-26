package com.accountfy.livros.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountfy.livros.entities.Livro;
import com.accountfy.livros.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	@Autowired
	private LivroService service;
	
	@GetMapping
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id){
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/count")
	public ResponseEntity<Long> count(){
		Long count = service.count();
		return ResponseEntity.ok().body(count);
	}
}
