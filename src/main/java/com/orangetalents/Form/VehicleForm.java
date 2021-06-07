package com.orangetalents.Form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleForm {

	@NotNull
	@NotEmpty
	private String marca;
	
	@NotNull
	@NotEmpty
	private String modelo;
	
//	@NotNull
//	@NotEmpty
	private int ano;
	
	private BigDecimal valor;
	
	
	public VehicleForm(String marca, String modelo, int ano, BigDecimal valor ) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
}
