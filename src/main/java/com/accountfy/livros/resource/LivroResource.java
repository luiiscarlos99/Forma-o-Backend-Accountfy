package com.accountfy.livros.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accountfy.livros.entities.Livro;
import com.accountfy.livros.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	@Autowired
	private LivroService service;
	
	@GetMapping
	public ResponseEntity<List<Livro>> obterTodos(){
		List<Livro> list = service.obterTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> encontrarPeloId(@PathVariable Long id){
		Livro obj = service.encontrarPeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/contarTodos")
	public ResponseEntity<Long> contarTodos(){
		Long count = service.contarTodos();
		return ResponseEntity.ok().body(count);
	}
	
	@GetMapping(value = "/naoEstaVazio")
	public ResponseEntity<Boolean> naoEstaVazio(){
		Boolean flag = service.naoEstaVazio();
		return ResponseEntity.ok().body(flag);
	}
	
	@GetMapping(value = "/estaVazio")
	public ResponseEntity<Boolean> estaVazio(){
		Boolean flag = service.estaVazio();
		return ResponseEntity.ok().body(flag);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Livro obj){
		//obj = service.salvar(obj);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//return ResponseEntity.created(uri).body(obj);
		service.salvar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirPeloId(@PathVariable Long id){
		service.excluirPeloId(id);
		return ResponseEntity.noContent().build();
	}
}
