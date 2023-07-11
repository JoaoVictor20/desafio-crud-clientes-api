package com.projetos.desafio.models.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacaoRequest {

	private String login;
	private String senha;
}