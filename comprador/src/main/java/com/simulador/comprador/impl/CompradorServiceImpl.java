package com.simulador.comprador.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.simulador.comprador.model.Acoes;
import com.simulador.comprador.model.Comprador;
import com.simulador.comprador.repository.CompradorRepository;
import com.simulador.comprador.services.CompradorService;

@Service
public class CompradorServiceImpl implements CompradorService {

	@Autowired
	private CompradorRepository compradorRepository;

	private RestTemplate acoesTemplate = new RestTemplateBuilder().rootUri("http://localhost:8088/carteira").build();

	@Override
	public List<Comprador> listarCompradores(){
		return this.compradorRepository.findAll();
	}
	
	@Override
	public Comprador selecionaUmComprador(String id) {
		return this.compradorRepository.getOne(id);
	}
	
	@Override
	public Comprador inserirComprador(Comprador comprador) {
		return this.compradorRepository.save(comprador);
	}
	
	@Override
	public Comprador atualizarComprador (Comprador comprador) {
		return this.compradorRepository.save(comprador);
	}
	
	@Override
	public void deletarComprador (String id) {
		this.compradorRepository.delete(id);
	}
	
	@Override
	public List<Acoes> listarTodasAcoes() {
		ResponseEntity<List<Acoes>> exchange = this.acoesTemplate.exchange("/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Acoes>>() {
				});
		return exchange.getBody();
	}
	
	@Override
	public Acoes colocaAcaoNaCarteira(Acoes acoes, String id, String nome, double investimento) {
		Comprador comprador = new Comprador();
		comprador.setId(id);
		comprador.setNome(nome);
		comprador.setSaldo(investimento);
		comprador.setVolume(0);
		comprador.setAcoes(acoes.getCodigo());
		this.compradorRepository.save(comprador);
		ResponseEntity<Acoes> exchangePut = this.acoesTemplate.exchange("/" + acoes.getCodigo(), HttpMethod.PUT,
				new HttpEntity<>(acoes, creatJsonHeader()), Acoes.class);
		return exchangePut.getBody();
	}

	@Override
	public Acoes comprarAcao(Comprador comprador, Acoes acoes) {
		comprador.setVolume((Math.floor(comprador.getSaldo()/acoes.getValor())*100)/100);
		comprador.setSaldo(0);
		this.compradorRepository.save(comprador);
		return acoes;
	}

	@Override
	public Acoes venderAcao(Comprador comprador, Acoes acoes) {
		comprador.setSaldo((Math.floor(comprador.getVolume()*acoes.getValor()*100)/100));
		comprador.setVolume(0);
		this.compradorRepository.save(comprador);
		return acoes;
	}

	@Override
	public void removerAcaoDaCarteira(String codigo) {
		this.compradorRepository.delete(codigo);
	}


	private static HttpHeaders creatJsonHeader() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return header;
	}
	

}
