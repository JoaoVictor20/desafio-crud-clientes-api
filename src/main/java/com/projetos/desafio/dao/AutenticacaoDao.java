package com.projetos.desafio.dao;

import com.projetos.desafio.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutenticacaoDao extends JpaRepository<Usuario, Long> {

    Usuario findByLogin(String login);
}