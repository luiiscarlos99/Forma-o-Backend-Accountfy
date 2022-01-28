package com.accountfy.livros.resources;

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

import com.accountfy.livros.entities.AnoMes;
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
	
	@GetMapping(value = "/tituloContendo/{titulo}")
	public ResponseEntity<List<Livro>> obterComTituloContendo(@PathVariable String titulo){
		List<Livro> obj = service.obterComTituloContendo(titulo);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/publicadosEmList")
	public ResponseEntity<List<Livro>> obterPublicadosEm(@RequestBody List<AnoMes> ref){
		List<Livro> obj = service.obterPublicadosEm(ref);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/publicadosEm")
	public ResponseEntity<List<Livro>> obterPublicadosEm(@RequestBody AnoMes ref){
		List<Livro> obj = service.obterPublicadosEm(ref);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Livro obj){
		service.salvar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirPeloId(@PathVariable Long id){
		service.excluirPeloId(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/excluirTodos")
	public ResponseEntity<Void> excluirTodos(){
		service.excluirTodos();
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> excluir(@RequestBody Livro obj){
		service.excluir(obj);
		return ResponseEntity.noContent().build();
	}
}
