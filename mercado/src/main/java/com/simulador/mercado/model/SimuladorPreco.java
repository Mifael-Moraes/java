package com.simulador.mercado.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.simulador.mercado.model.Acoes;



public class SimuladorPreco extends Thread {

	List<Acoes> listaAcoes = new ArrayList<Acoes>();
	boolean t = true;
	private RestTemplate acoesTempate = new RestTemplateBuilder().rootUri("http://localhost:8088/acoes").build();
	public SimuladorPreco() {

	}

	public void getAcoes() {
		ResponseEntity<List<Acoes>> exchange = acoesTempate.exchange("/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Acoes>>() {
				});
		if (exchange.hasBody()) {
			while (t) {
				try {
					for (int i = 0; i < exchange.getBody().size(); i++) {
						if (exchange.getBody().get(i).isIniciar()) {
							run(exchange.getBody().get(i));
							}
					}
					sleep(5000);
				} catch (Exception e) {
					e.getStackTrace();
				}
				exchange = acoesTempate.exchange("/", HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Acoes>>() {
						});
			}
		}
	}

	private static HttpHeaders creatJsonHeader() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return header;
	}

	public Acoes variaValor(Acoes acoes) {
		double PMin = acoes.getPrecoCompra() - (acoes.getPrecoCompra() * 0.1);
		double PMax = acoes.getPrecoVenda() + (acoes.getPrecoVenda() * 0.1);
		acoes.setValor((Math.floor(ThreadLocalRandom.current().nextDouble(PMin, PMax) * 100)) / 100);
		return acoes;
	}

	public void run(Acoes acoes) {
		variaValor(acoes);
		ResponseEntity<Acoes> exchangePut = acoesTempate.exchange("/" + acoes.getCodigo(), HttpMethod.PUT,
				new HttpEntity<>(acoes, creatJsonHeader()), Acoes.class);

		// System.out.println("Enviou Atualização no banco com valor = " +
		// acoes.getValor());
	}

	public boolean isT() {
		return t;
	}

	public void setT(boolean t) {
		this.t = t;
	}

}
