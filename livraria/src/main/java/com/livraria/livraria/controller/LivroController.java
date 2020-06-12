package com.livraria.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.livraria.livraria.model.LivroModel;
import com.livraria.livraria.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
@CrossOrigin("*")
public class LivroController {
	@Autowired
	private LivroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<LivroModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroModel> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<LivroModel>> GetByNome(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<List<LivroModel>> GetByIsbn(@PathVariable String isbn){
		return ResponseEntity.ok(repository.findAllByIsbnContainingIgnoreCase(isbn));
	}
	
	@PostMapping
	public ResponseEntity<LivroModel> post(@RequestBody LivroModel Livro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Livro));
	}
	
	@PutMapping
	public ResponseEntity<LivroModel> put (@RequestBody LivroModel livro) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(livro));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
