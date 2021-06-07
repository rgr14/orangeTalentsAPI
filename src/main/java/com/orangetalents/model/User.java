package com.orangetalents.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//Tabela
@Entity
@Table(name="tb_users")
public class User {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable= false)
	private String nome;
	
	
	@Column(nullable= false, unique= true)
	private String email;
	
	
	@Column(nullable= false, unique= true)
	private String cpf;
	
	
	@Column(nullable= false)
	private LocalDate dataNascimento;
	
	
	//Mapeando relação 1 para M no banco, uma pessoa tem vários carros
	//Cascade quando deletar usuario deleta o carro junto
	@JsonIgnoreProperties("user")
	@OneToMany(mappedBy = "user", cascade= CascadeType.ALL)
	private List<Car> carros = new ArrayList<>();
	
	
	public User() {
			
	}

	public User(Long id, String nome, String email, String cpf, LocalDate dataNascimento, List<Car> carros) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.carros = carros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public List<Car> getCarros() {
		return carros;
	}

	public void setCarros(List<Car> carros) {
		this.carros = carros;
	}
	
	
}
