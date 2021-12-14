package br.com.projetoatos1.projeto_atos1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import br.com.projetoatos1.projeto_atos1.models.entities.Produto;
import br.com.projetoatos1.projeto_atos1.models.repositories.ProdutoRepository;

@Controller
public class IndexController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
		return "index";
	}
	
	

}

