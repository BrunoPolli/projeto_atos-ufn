package br.com.projetoatos1.projeto_atos1.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PrimeiroController {

	@RequestMapping("/cadastrar")
	public String form() {
	
		return "form";
	}
	
	
	
}
