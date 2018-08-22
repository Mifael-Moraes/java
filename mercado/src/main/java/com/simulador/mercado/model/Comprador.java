package com.simulador.mercado.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comprador {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("volume")
	private double volume;
	
	@JsonProperty("saldo")
	private double saldo;
	
	@JsonProperty("acoes")
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
