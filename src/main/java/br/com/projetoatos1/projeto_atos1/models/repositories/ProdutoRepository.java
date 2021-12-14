package br.com.projetoatos1.projeto_atos1.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import br.com.projetoatos1.projeto_atos1.models.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	Produto findById(int id);
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
}
 //