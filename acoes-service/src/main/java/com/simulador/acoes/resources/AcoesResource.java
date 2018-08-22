package com.simulador.acoes.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulador.acoes.model.Acoes;
import com.simulador.acoes.services.AcoesService;


@RestController
@RequestMapping(path = "/acoes")
public class AcoesResource {
	
	@Autowired
	private AcoesService acoesService;
	
	@GetMapping()
	public ResponseEntity<List<Acoes>> listarTodos(){
		return ResponseEntity.ok(this.acoesService.listarTodos());
	}
	
	@GetMapping(path = "{codigo}", produces="application/json")
	public ResponseEntity<Acoes> listarPorCodigo(@PathVariable(name= "codigo") String codigo){
		return ResponseEntity.ok(this.acoesService.listarPorCodigo(codigo));
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<Acoes> cadastrar(@Valid @RequestBody Acoes acoes){
		return ResponseEntity.ok(this.acoesService.cadastrar(acoes));
	}
	
	@PutMapping(path= "/{codigo}")
	public ResponseEntity<Acoes> atualizar(@PathVariable(name="codigo")String codigo,@Valid @RequestBody Acoes acoes){
		acoes.setCodigo(codigo);
		return ResponseEntity.ok(this.acoesService.atualizar(acoes));
	}
	
	@DeleteMapping(path= "/{codigo}")
	public ResponseEntity<Integer> remover(@PathVariable(name="codigo")String codigo){
		this.acoesService.remover(codigo);
		return ResponseEntity.ok(1);
	}
}
