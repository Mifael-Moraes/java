package com.simulador.autobooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulador.autobooking.model.LogNegociacao;

public interface AutobookingRepository extends JpaRepository<LogNegociacao, String> {

}
