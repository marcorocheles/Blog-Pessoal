package org.generation.blog.repository;

import java.util.List;

import org.generation.blog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Esta camada é responsável pela comunicação com o bando de dados
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	/*
	 * Method Query equivalente a instrução SQL
	 * SELECT * FROM tb_postagem where like %titulo%
	 * Case = lowerCase ou UpperCase e não CASO
	 */
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
