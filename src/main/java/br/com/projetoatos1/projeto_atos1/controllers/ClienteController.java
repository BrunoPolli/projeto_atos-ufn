package br.com.projetoatos1.projeto_atos1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoatos1.projeto_atos1.models.entities.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28, "Pedro", "123");
	}
	
	@GetMapping(path = "/{id}")
	public Cliente obterClientePorId1(@PathVariable int id) {
		return new Cliente(id, "Maria", "456");
	}
	
	@GetMapping
	public Cliente obterClientePorId2(@RequestParam(name="id") int id) {
		return new Cliente(id, "Joao", "789");
	}
	
}
