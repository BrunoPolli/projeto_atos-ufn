package br.com.projetoatos1.projeto_atos1.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoatos1.projeto_atos1.models.entities.Produto;
import br.com.projetoatos1.projeto_atos1.models.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novoProduto(Produto produto) {
		
		produtoRepository.save(produto);
		
		return produto;
	}
	
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		
		return produtoRepository.findAll();
	}
	
	@GetMapping(path="/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		
		return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
	}

	/*
	@GetMapping(path="/pagina/{numeroPagina}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina){
		if(qtdPagina >= 5) qtdPagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdPagina);
		return produtoRepository.findAll(page);
	}
	
	@GetMapping(path="/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	@PutMapping
	public Produto alterarProduto(Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@DeleteMapping(path="/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
	*/
}
