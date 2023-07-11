package com.projetos.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.desafio.models.entities.Usuario;
import com.projetos.desafio.models.requests.AutenticacaoRequest;
import com.projetos.desafio.models.response.AutenticacaoResponse;
import com.projetos.desafio.security.TokenService;

@RestController
@RequestMapping("/autorizacao")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping(value = "/login")
	public ResponseEntity logarUsuario(@RequestBody AutenticacaoRequest authenticationDTO) {

		var userNamePasswordAuthentication = new UsernamePasswordAuthenticationToken(authenticationDTO.getLogin(),
				authenticationDTO.getSenha());
		var autorizacao = this.authenticationManager.authenticate(userNamePasswordAuthentication);

		AutenticacaoResponse autenticacaoResponse = new AutenticacaoResponse();
		autenticacaoResponse.setToken(tokenService.generateToken((Usuario) autorizacao.getPrincipal()));
		Usuario usuario = (Usuario) autorizacao.getPrincipal();
		autenticacaoResponse.setIdUsuario(usuario.getId());

		return ResponseEntity.ok(autenticacaoResponse);
	}
}