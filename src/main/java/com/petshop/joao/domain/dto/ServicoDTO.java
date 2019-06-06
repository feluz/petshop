package com.petshop.joao.domain.dto;

import java.io.Serializable;

import com.petshop.joao.domain.Servico;

public class ServicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	//@NotEmpty(message="Preenchimento obrigatório")
	//@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;

	public ServicoDTO() {
	}
	
	public ServicoDTO(Servico obj) {
		id = obj.getId();
		nome = obj.getNomedoservico();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}