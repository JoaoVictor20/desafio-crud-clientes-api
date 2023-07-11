package com.projetos.desafio.dao;

import com.projetos.desafio.models.entities.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
	
	@Query("SELECT c FROM Cliente c WHERE c.usuario.id = ?1")
	List<Cliente> buscarClientesDoUsuario(Long usuario_id);
}