package com.petshop.joao.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomedoservico;
	
	private String descricao;
	private Double valor;
	
	@JsonIgnore
	@OneToMany(mappedBy="servico")
	private List<Agendamento> agendamentos = new ArrayList<>();
	
	public Servico() {
	}
	
	public Servico(Integer id, String nomedoservico, String descricao, Double valor) {
		super();
		this.id = id;
		this.nomedoservico = nomedoservico;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomedoservico() {
		return nomedoservico;
	}
	public void setNomedoservico(String nomedoservico) {
		this.nomedoservico = nomedoservico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	
	
}
