package org.generation.blog.controller;

import java.util.List;

import org.generation.blog.model.Postagem;
import org.generation.blog.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //identifica que esta camada é a controller
@RequestMapping ("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
		
	
		//declara um repository e depois o nome dele que pode ser qualquer coisa
		@Autowired
		private PostagemRepository postagemRepository;
		
	
		@GetMapping
		public ResponseEntity<List<Postagem>> findAll(){
			return ResponseEntity.ok(postagemRepository.findAll());
			
		}
		
		/* Retorna uma postagem pelo id
		 * Primeiro deve-se escolher onde o usuario vai entrar com o getmapping
		 * o valor entre {} é o que o usuario vai inserir
		*/ 
	    @GetMapping("/{id}")
	    
	    //aqui declaramos o ResponseEntity solicitando 1 item do postagem e declaramos a classe e seu tipo - variavel - entre ()
	    // e o @PathVariable permite dizer que o valor da variavel virá do url digitado acima pelo usuario 
	    public ResponseEntity<Postagem> GetById(@PathVariable long id){ 
	    	
	    	/*agora faremos o retorno do getbyID, onde declaramos a comunicação com o banc de dados, o postagemRepository e
	    	o findById com a variavel id entre (), esse retorno retorna um option que pode ser populado ou nulo
	    	logo após um .map faz esse trabalho e criaremos um "if else" onde se estiver populado retornaremos e se nao dará not found
	    	*/
	        return postagemRepository.findById(id)
	        .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	    }

	    /*
	     *  Retorna postagem pelo título. o inciio da sintaxe é similar ao do id,  com exceção do getMapping que
	     *  precisa de um espaço a mais. Uma variavel String chamada titulo é criada e o return ocorre similar ao do postagens
	     *  com exceção da declaração da postagem q criamos no PostagemRepository
	    */
	    @GetMapping("/titulo/{titulo}")
	    public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
	    	return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	    }
	    
	    //post e delete
	    
	    @PostMapping
		public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
			return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
		}
	    
	    
		@PutMapping
		public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteRepository(@PathVariable long id) {
			return postagemRepository.findById(id).map(resposta -> {
				postagemRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}).orElse(ResponseEntity.notFound().build());
		}
		
}
