package com.simulador.autobooking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class LogNegociacao {
	
	//[YZK] Compra: 10.15, Volume: 10000, Saldo: 0.00
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataHora;
	@NotBlank
	private String nomeAcao;
	@NotBlank
	private String operacao;
	@NotNull
	private double valorOperacao;
	@NotNull
	private double volumeAcoes;
	@NotNull
	private double saldo;
	
	public LogNegociacao() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getNomeAcao() {
		return nomeAcao;
	}
	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public double getValorOperacao() {
		return valorOperacao;
	}
	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}
	public double getVolumeAcoes() {
		return volumeAcoes;
	}
	public void setVolumeAcoes(double volumeAcoes) {
		this.volumeAcoes = volumeAcoes;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "#"+ dataHora +": [" + nomeAcao + "] " + operacao + ": "
				+ valorOperacao + ", Volume: " + volumeAcoes + ", Saldo: " + saldo;
	}
	
	

}
