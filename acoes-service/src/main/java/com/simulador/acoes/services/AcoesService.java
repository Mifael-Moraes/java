package com.simulador.acoes.services;

import java.util.List;

import com.simulador.acoes.model.Acoes;

public interface AcoesService {

	List<Acoes> listarTodos();
	
	Acoes listarPorCodigo(String codigo);
	
	Acoes cadastrar(Acoes acoes);
	
	Acoes atualizar(Acoes acoes);
	
	void remover(String codigo);
}
