package br.com.cursowebmestredetalhe.model;

import java.io.Serializable;

public class Estado extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private String sigla;
	
	public Estado() {
		super();
	}
	public Estado(Long id) {
		this();
		setId(id);
	}

	/* Getters e Setters */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}