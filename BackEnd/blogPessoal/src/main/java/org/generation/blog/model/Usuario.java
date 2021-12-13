package org.generation.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O campo nome é obrigatório!")
	@Size (min = 2, max = 100, message = "O campo nome deve conter entre 2 a 100 caracteres.")
	private String nome;
	
	@NotBlank (message = "O campo usuario é obrigatório!")
	@Size (min = 8, max = 100, message = "O campo usuario deve conter entre 8 a 50 caracteres.")
	private String usuario;
	
	@NotBlank (message = "O campo senha é obrigatório!")
	@Size (min = 6, max = 50, message = "O campo usuario deve conter entre 6 a 50 caracteres.")
	private String senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
