package com.projetos.desafio.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.projetos.desafio.models.entities.Usuario;
import com.projetos.desafio.util.Constantes;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;

	@Autowired
	private Constantes contantes;

	public String generateToken(Usuario usuario) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer(contantes.getNOME_PROJETO()).withSubject(usuario.getLogin())
					.withExpiresAt(generateExpirationData()).sign(algorithm);
			return token;

		} catch (JWTCreationException jWTCreationException) {
			throw new RuntimeException(contantes.getERRO_AO_GERAR_TOKEN(), jWTCreationException);
		}
	}

	public String validarToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer(contantes.getNOME_PROJETO()).build().verify(token).getSubject();
		} catch (JWTVerificationException exception) {
			throw new RuntimeException(contantes.getERRO_AO_VALIDAR_TOKEN());
		}
	}

	private Instant generateExpirationData() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of(contantes.getTIME_ZONE_BRASILIA()));
	}
}