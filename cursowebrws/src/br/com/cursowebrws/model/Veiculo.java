package br.com.cursowebrws.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.cursowebrws.adapter.DateAdapter;

public class Veiculo extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String placa;
	private String nomeProprietario;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dataEmplacamento;
	private Double valorIpva;
	
	public Veiculo() {
		super();
	}
	public Veiculo(Long id) {
		this();
		setId(id);
	}

	/* Getters e Setters */
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	
	public Date getDataEmplacamento() {
		return dataEmplacamento;
	}
	public void setDataEmplacamento(Date dataEmplacamento) {
		this.dataEmplacamento = dataEmplacamento;
	}
	public Double getValorIpva() {
		return valorIpva;
	}
	public void setValorIpva(Double valorIpva) {
		this.valorIpva = valorIpva;
	}	
}