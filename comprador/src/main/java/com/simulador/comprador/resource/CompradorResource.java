package com.simulador.comprador.resource;

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

import com.simulador.comprador.model.Acoes;
import com.simulador.comprador.model.Comprador;
import com.simulador.comprador.services.CompradorService;

@RestController
@RequestMapping(path = "/carteira")
public class CompradorResource {
	
	@Autowired
	private CompradorService compradorService;
	
	//metodos comprador
	
	@GetMapping
	public ResponseEntity<List<Comprador>> listarTodos(){
		return ResponseEntity.ok(this.compradorService.listarCompradores());
	}
	
	@GetMapping(path= "/{id}")
	public ResponseEntity<Comprador> selecionaComprador(@PathVariable(name="id")String id) {
		return ResponseEntity.ok(this.compradorService.selecionaUmComprador(id));
	}
	
	@PostMapping
	public ResponseEntity<Comprador> adicionaComprador(@RequestBody Comprador comprador){
		return ResponseEntity.ok(this.compradorService.inserirComprador(comprador));
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Comprador> atualizaComprador(@PathVariable(name="id")String id,@Valid @RequestBody Comprador comprador){
		comprador.setId(id);
		return ResponseEntity.ok(this.compradorService.atualizarComprador(comprador));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Integer> deletaComprador(@PathVariable(name="id") String id){
		this.compradorService.deletarComprador(id);
		return ResponseEntity.ok(1);
	}
	
	//metodos acoes
	
	@GetMapping(path="/acoes")
	public ResponseEntity<List<Acoes>> listarTodas(){
		return ResponseEntity.ok(this.compradorService.listarTodasAcoes());
	}
	
	@PutMapping(path= "/acao/{id}/")
	public ResponseEntity<Acoes> selecionaAcao(@PathVariable(name="id")String id,@RequestBody Acoes acoes) {
		Comprador comprador = this.compradorService.selecionaUmComprador(id);
		return ResponseEntity.ok(this.compradorService.colocaAcaoNaCarteira(acoes, id, comprador.getNome(), comprador.getSaldo()));
	}
	
	@PutMapping(path="/acao/comprar/{id}")
	public ResponseEntity<Acoes> comprarAcao(@PathVariable(name="id")String id,@RequestBody Acoes acoes){
		Comprador comprador = this.compradorService.selecionaUmComprador(id);
		return ResponseEntity.ok(this.compradorService.comprarAcao(comprador, acoes));
	}
	
	@PutMapping(path="/acao/vender/{id}")
	public ResponseEntity<Acoes> venderAcao(@PathVariable(name="id")String id,@RequestBody Acoes acoes){
		Comprador comprador = this.compradorService.selecionaUmComprador(id);
		return ResponseEntity.ok(this.compradorService.venderAcao(comprador, acoes));
	}
	
	@DeleteMapping(path="/acoes/{codigo}")
	public void retirarAcaoDaCarteira(@PathVariable(name="codigo")String codigo) {
		this.compradorService.removerAcaoDaCarteira(codigo);
	}

}
