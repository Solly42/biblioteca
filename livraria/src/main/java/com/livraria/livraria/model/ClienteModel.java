package com.livraria.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel {
	@Column(name = "idCliente")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "cdCpf", nullable = false, unique = true)
	@Size(min = 11, max = 11, message = "Insira somente os números")
	private String cpf;

	@Column(name = "nmNome", nullable = false)
	@Size(min = 2, max = 200)
	private String nome;

	@Column(name = "nmEmail", nullable = true)
	@Size(min = 5, max = 200)
	private String email;

	@Column(name = "nmTelefone", nullable = true)
	@Size(min = 10, max = 11)
	private String telefone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
