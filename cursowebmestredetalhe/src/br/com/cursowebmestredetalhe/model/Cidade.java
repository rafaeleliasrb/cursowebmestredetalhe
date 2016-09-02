package br.com.cursowebmestredetalhe.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.cursowebmestredetalhe.adapter.DateAdapter;

public class Cidade extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dataConstituicao;
	private Double populacao;
	private Double pib;
	private Estado estado;
	
	public Cidade() {
		super();
	}
	public Cidade(Long id) {
		this();
		setId(id);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataConstituicao() {
		return dataConstituicao;
	}
	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}
	public Double getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Double populacao) {
		this.populacao = populacao;
	}
	public Double getPib() {
		return pib;
	}
	public void setPib(Double pib) {
		this.pib = pib;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}