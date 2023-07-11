package com.projetos.desafio.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.projetos.desafio.models.entities.Usuario;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;

	public String generateToken(Usuario usuario) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer("desafio").withSubject(usuario.getLogin())
					.withExpiresAt(generateExpirationData()).sign(algorithm);
			return token;

		} catch (JWTCreationException jWTCreationException) {
			throw new RuntimeException("Erro ao gerar o token", jWTCreationException);
		}
	}

	public String validarToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("desafio").build().verify(token).getSubject();
		} catch (JWTVerificationException exception) {
			return "";
		}
	}

	private Instant generateExpirationData() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}