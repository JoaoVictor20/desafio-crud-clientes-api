package com.projetos.desafio.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacaoResponse {

	private Long idUsuario;
	private String token;
}