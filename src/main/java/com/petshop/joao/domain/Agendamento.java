package com.petshop.joao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomedodono;
	
	private String telefone;
	private String email;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	@JsonFormat(pattern="HH:mm")
	private Date hora;
	
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	public Agendamento() {
		
	}
	
	public Agendamento(Integer id, String nomedodono, String telefone, String email, Date data, Date hora, Servico servico) {
		super();
		this.id = id;
		this.nomedodono = nomedodono;
		this.telefone = telefone;
		this.email = email;
		this.data = data;
		this.hora = hora;
		this.servico = servico;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomedodono() {
		return nomedodono;
	}
	public void setNomedodono(String nomedodono) {
		this.nomedodono = nomedodono;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
