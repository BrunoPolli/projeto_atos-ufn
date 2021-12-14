package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoatos1.projeto_atos1.models.entities.Produto;
import br.com.projetoatos1.projeto_atos1.models.repositories.ProdutoRepository;

@Service
public class ProdutoServices {

	@Autowired
	public ProdutoRepository prodServiceRepository;
	
	public Produto get(int id) {
		return prodServiceRepository.findById(id);
	}
	
	public void delete(int id) {
		prodServiceRepository.deleteById(id);
	}
}
