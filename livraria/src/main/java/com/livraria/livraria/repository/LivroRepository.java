package com.livraria.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.livraria.model.LivroModel;




@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {
	public List<LivroModel> findAllByTituloContainingIgnoreCase(String titulo);
	public List<LivroModel> findAllByIsbnContainingIgnoreCase(String isbn);
	
}
