package com.simulador.comprador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulador.comprador.model.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, String> {
	
}
