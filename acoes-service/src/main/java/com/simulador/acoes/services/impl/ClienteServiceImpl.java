package com.simulador.acoes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulador.acoes.model.Acoes;
import com.simulador.acoes.repository.AcoesRepository;
import com.simulador.acoes.services.AcoesService;

@Service
public class ClienteServiceImpl implements AcoesService {

	@Autowired
	private AcoesRepository acoesRepository;
	
	@Override
	public List<Acoes> listarTodos() {
		return this.acoesRepository.findAll();
	}

	@Override
	public Acoes listarPorCodigo(String codigo) {
		return this.acoesRepository.findOne(codigo);
	}

	@Override
	public Acoes cadastrar(Acoes acoes) {
		return this.acoesRepository.save(acoes);
	}

	@Override
	public Acoes atualizar(Acoes acoes) {
		return this.acoesRepository.save(acoes);
	}

	@Override
	public void remover(String codigo) {
		this.acoesRepository.delete(codigo);

	}

	
}
