package com.simulador.comprador.services;

import java.util.List;

import com.simulador.comprador.model.Acoes;
import com.simulador.comprador.model.Comprador;

public interface CompradorService {
	
	//metodos comprador
	
	List<Comprador> listarCompradores();
	
	Comprador selecionaUmComprador(String id);
	
	Comprador inserirComprador(Comprador comprador);
	
	Comprador atualizarComprador (Comprador comprador);
	
	void deletarComprador (String id);
	
	//metodos comprador/acões
	
	List<Acoes> listarTodasAcoes();
	
	Acoes colocaAcaoNaCarteira(Acoes acoes,String id, String nome, double investimento);
	
	Acoes comprarAcao(Comprador comprador, Acoes acoes);
	
	Acoes venderAcao(Comprador comprador, Acoes acoes);
	
	void removerAcaoDaCarteira(String codigo);

}
