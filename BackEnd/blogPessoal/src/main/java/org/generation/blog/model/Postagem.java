package org.generation.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Model é a classe responsável pela comunicação com o banco de dados, onde fica a tabela
@Entity //Anotação que indica que essa classe fará relação com o mySQL
@Table (name = "postagem") //essa entidade criará uma tabela no mySQL com o nome postagem

public class Postagem {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // se tornara uma primary key
		private long id;
		
		@NotNull
		@Size(min = 5, max = 100, message = "O atributo titulo deve conter no minimo 5 caracteres.")
		private String titulo;
		
		@NotNull
		@Size(min = 10, max = 1500, message = "O atributo titulo deve conter no minimo 10 caracteres.")
		private String texto;
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date data = new java.sql.Date(System.currentTimeMillis()); 
		//assim que passar um dado por esta classe ele irá capturar a data, hora e segundo
		
		@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Tema tema;
		
		
		
		//gerando getters and setters
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getTexto() {
			return texto;
		}
		public void setTexto(String texto) {
			this.texto = texto;
		}
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}

		public Tema getTema() {
			return tema;
		}
		public void setTema(Tema tema) {
			this.tema = tema;
		}
		
}
