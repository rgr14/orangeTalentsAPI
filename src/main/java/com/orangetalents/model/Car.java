package com.orangetalents.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



//Tabela
@Entity
@Table(name="tb_carros")
public class Car {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable= false)
	private String marca;
	
	
	@Column(nullable= false)
	private String modelo;
	
	
	@Column(nullable= false)
	private int ano;
	
	@Column(nullable= false)
	private String diaRodizio;
	
	@Column(nullable= false)
	private BigDecimal valor;
	
	//Mapeamento inverso, vários carros para uma pessoa
	@ManyToOne
	private User user;
	
	public Car() {
		
	}

	public Car(Long id, String marca, String modelo, int ano, String diaRodizio, BigDecimal valor, User user) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.diaRodizio = diaRodizio;
		this.valor = valor;
		this.user = user;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDiaRodizio() {
		return diaRodizio;
	}

	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}
	
	
	
}
