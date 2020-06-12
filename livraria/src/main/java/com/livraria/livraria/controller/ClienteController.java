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

import com.livraria.livraria.model.ClienteModel;
import com.livraria.livraria.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;

	@GetMapping
	public ResponseEntity<List<ClienteModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<ClienteModel>> GetByCpf(@PathVariable String cpf) {
		return ResponseEntity.ok(repository.findAllByCpfContainingIgnoreCase(cpf));
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ClienteModel>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<ClienteModel> post(@RequestBody ClienteModel Cliente) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Cliente));
	}

	@PutMapping
	public ResponseEntity<ClienteModel> put(@RequestBody ClienteModel cliente) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
