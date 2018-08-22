package com.simulador.autobooking.servicesimpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulador.autobooking.model.Acoes;
import com.simulador.autobooking.model.LogNegociacao;
import com.simulador.autobooking.repository.AutobookingRepository;
import com.simulador.autobooking.services.AutoBookingService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class AutobookingServiceImpl implements AutoBookingService {

	@Autowired
	private AutobookingRepository autobookingRepository;
	
	@Override
	public LogNegociacao comprar(String nomeAcao, Double ValorCompra, Double VolumeAcoes, Double Saldo) {
		LogNegociacao log = new LogNegociacao();
		log.setDataHora(new Date(System.currentTimeMillis()));
		log.setNomeAcao(nomeAcao);
		log.setOperacao("COMPRA");
		log.setValorOperacao(ValorCompra);
		log.setVolumeAcoes(VolumeAcoes);
		log.setSaldo(Saldo);
		System.out.println(log.toString());
		return this.autobookingRepository.save(log);
	}

	@Override
	public LogNegociacao vender(String nomeAcao, Double ValorCompra, Double VolumeAcoes, Double Saldo) {
		LogNegociacao log = new LogNegociacao();
		log.setDataHora( new Date(System.currentTimeMillis()));
		log.setNomeAcao(nomeAcao);
		log.setOperacao("VENDA");
		log.setValorOperacao(ValorCompra);
		log.setVolumeAcoes(VolumeAcoes);
		log.setSaldo(Saldo);
		System.out.println(log.toString());
		return this.autobookingRepository.save(log);
	}

}
