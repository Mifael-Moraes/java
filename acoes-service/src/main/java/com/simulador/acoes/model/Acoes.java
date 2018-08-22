package com.simulador.acoes.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Acoes {
	
	@Id
	private String codigo;
	
	@NotBlank	
	private String nome;
	
	private String idComprador;
			
	private boolean iniciar;
	
	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double valor;

	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double precoVenda;
	
	@NotNull
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	private double precoCompra;
	
	public Acoes() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(String idComprador) {
		this.idComprador = idComprador;
	}

	public boolean isIniciar() {
		return iniciar;
	}
	
	public void setIniciar(boolean iniciar) {
		this.iniciar = iniciar;
	}	

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Nome: " + nome + ", Comprador: " + idComprador +  ", Iniciar: " + iniciar + ", Valor: " + valor + ", Preco Venda: " + precoVenda
				+ ", Preco Compra: " + precoCompra + "\n";
	}

	
}
