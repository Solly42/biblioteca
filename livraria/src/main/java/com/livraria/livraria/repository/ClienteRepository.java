package com.livraria.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.livraria.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
	public List <ClienteModel> findAllByCpfContainingIgnoreCase(String	cpf );
	public List <ClienteModel> findAllByNomeContainingIgnoreCase(String	nome );

}
