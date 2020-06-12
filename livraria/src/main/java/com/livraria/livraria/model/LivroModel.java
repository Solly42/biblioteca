package com.livraria.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_LIVRO")
public class LivroModel {
	@Column(name = "idLivro")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "cdIsbn")
	@NotNull
	@Size(min = 13, max = 17)
	private String isbn;

	@Column(name = "nmTitulo")
	@NotNull
	@Size(min = 3, max = 80)
	private String titulo;

	@Column(name = "nmGenero")
	@NotNull
	@Size(min = 3, max = 80)
	private String genero;

	@Column(name = "nmAutor")
	@NotNull
	@Size(min = 3, max = 80)
	private String autor;

	@Column(name = "cdDisponivel")
	@NotNull
	private Boolean disponivel;

	@Column(name = "qtEstoque")
	@NotNull
	int quantidadeEstoque;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

}
