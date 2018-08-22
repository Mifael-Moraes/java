package com.simulador.acoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulador.acoes.model.Acoes;

public interface AcoesRepository extends JpaRepository<Acoes, String>{
	

}
