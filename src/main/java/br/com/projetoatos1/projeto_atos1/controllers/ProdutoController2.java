package br.com.projetoatos1.projeto_atos1.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetoatos1.projeto_atos1.models.entities.Produto;
import br.com.projetoatos1.projeto_atos1.models.repositories.ProdutoRepository;

@Controller
public class ProdutoController2 {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(value="/cadastrarProduto", method=RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="/cadastrarProduto", method=RequestMethod.POST)
	public String form(Produto produto) {
		
		produtoRepository.save(produto);
		
		return "redirect:/cadastrarProduto";
	}
	
	@RequestMapping("/produtos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Produto> produtos = produtoRepository.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView descProduto(@PathVariable("id") int id) {
		Produto produto = produtoRepository.findById(id);
		ModelAndView mv = new ModelAndView("descProduto");
		mv.addObject("produto", produto);
		return mv;
	}
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterarProduto(@PathVariable(name="id") int id) {
		Produto produto = produtoRepository.findById(id);
		ModelAndView mv = new ModelAndView("alterar");
		mv.addObject("produto", produto);
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") int id) {
		produtoRepository.deleteById(id);
		return "redirect:/produtos";
		
	}
	
}

















