package com.petshop.joao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.petshop.joao.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}