package com.simulador.autobooking.resouces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simulador.autobooking.model.Acoes;
import com.simulador.autobooking.model.Comprador;
import com.simulador.autobooking.model.LogNegociacao;
import com.simulador.autobooking.services.AutoBookingService;

@RestController
@RequestMapping(path="/autobooking")
public class AutobookingResource {
	
	@Autowired 
	private AutoBookingService autobookingService;
	private RestTemplate acoesTemplate = new RestTemplateBuilder().rootUri("http://localhost:8088/acoes").build();
	RestTemplate compradorTemplate = new RestTemplateBuilder().rootUri("http://localhost:8889/carteira").build();
	
	
	
	@PutMapping(path="/compra/{id}")
	public void comprarAcoes(@PathVariable(name="id")String id, @RequestBody Acoes acoes){
		LogNegociacao log = new LogNegociacao();
		ResponseEntity<Comprador> comprador = compradorTemplate.exchange("/{id}",HttpMethod.GET ,null,Comprador.class, id);
		if(acoes.getValor() <= acoes.getPrecoCompra() & comprador.getBody().getSaldo() > 0) {
		 log = this.autobookingService.comprar(acoes.getNome(), acoes.getValor(), (Math.floor(comprador.getBody().getSaldo()/acoes.getValor()*100))/100, (double) 0);
		}
	}
	
	@PutMapping(path="/venda/{id}")
	public void venderAcoes(@PathVariable(name="id")String id, @RequestBody Acoes acoes){
		LogNegociacao log = new LogNegociacao();
		ResponseEntity<Comprador> comprador = compradorTemplate.exchange("/{id}",HttpMethod.GET ,null,Comprador.class, id);
		if(acoes.getValor() >= acoes.getPrecoVenda() & comprador.getBody().getVolume() > 0  ) {
		 log = this.autobookingService.vender(acoes.getNome(), acoes.getValor(), (double) 0, (Math.floor(comprador.getBody().getVolume()*acoes.getValor()*100))/100);
		}		
	}
	
	private static HttpHeaders creatJsonHeader() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return header;
	}
	
}
