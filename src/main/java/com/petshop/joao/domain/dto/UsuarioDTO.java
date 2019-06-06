package com.petshop.joao.domain.dto;

import java.io.Serializable;

import com.petshop.joao.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public UsuarioDTO() {
		super();
	}
	 
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
