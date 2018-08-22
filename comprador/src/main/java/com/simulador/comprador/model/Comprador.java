package com.simulador.comprador.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Comprador {

	@Id
	private String id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double volume;
	
	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double saldo;
	
	@NotBlank
	private String acoes;

	public Comprador() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getAcoes() {
		return acoes;
	}

	public void setAcoes(String acoes) {
		this.acoes = acoes;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Nome: " + nome + ", Volume: " + volume + ", Saldo: " + saldo + ", Acoes: " + acoes
				+ "\n";
	}
	
	
	
}
