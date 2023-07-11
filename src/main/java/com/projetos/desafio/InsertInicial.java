package com.projetos.desafio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projetos.desafio.models.entities.Usuario;
import com.projetos.desafio.service.AutenticacaoService;

@Configuration
public class InsertInicial implements CommandLineRunner{
	
	@Autowired
    private AutenticacaoService autenticacaoService;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuarioDeTeste = new Usuario();
		usuarioDeTeste.setLogin("JOAO");
		usuarioDeTeste.setSenha(new BCryptPasswordEncoder().encode("123"));
		autenticacaoService.salvarUsuario(usuarioDeTeste);	
	}
}