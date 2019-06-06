package com.petshop.joao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.joao.domain.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}