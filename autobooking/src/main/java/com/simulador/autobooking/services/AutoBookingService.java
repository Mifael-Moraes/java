package com.simulador.autobooking.services;

import com.simulador.autobooking.model.Acoes;
import com.simulador.autobooking.model.LogNegociacao;

public interface AutoBookingService {

	LogNegociacao comprar(String nomeAcao, Double ValorCompra, Double VolumeAcoes, Double Saldo);
	
	LogNegociacao vender(String nomeAcao, Double ValorCompra, Double VolumeAcoes, Double Saldo);
	
	
}
