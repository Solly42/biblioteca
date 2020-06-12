package com.livraria.livraria.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_COMPRA")
public class CompraModel {

	@Column(name = "cdCompra")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
	private ClienteModel cliente;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLivro", referencedColumnName = "idLivro")
	private LivroModel livro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public LivroModel getLivro() {
		return livro;
	}

	public void setLivro(LivroModel livro) {
		this.livro = livro;
	}

}
