package com.projetos.desafio.controller;

import com.projetos.desafio.util.*;
import com.projetos.desafio.models.entities.Cliente;
import com.projetos.desafio.models.requests.ClienteRequest;
import com.projetos.desafio.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private Constantes contantes;

	@PostMapping(value = "/cadastrar-cliente")
	public ResponseEntity<String> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
		try {
			clienteService.cadastrarCliente(clienteRequest);
			return ResponseEntity.ok(contantes.getSUCESSO_AO_SALVAR_CLIENTE());
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}

	@PutMapping(value = "/alterar-cliente")
	public ResponseEntity<String> alterarCliente(@RequestBody ClienteRequest clienteRequest) {
		try {
			clienteService.alterarCliente(clienteRequest);
			return ResponseEntity.ok(contantes.getSUCESSO_AO_ALTERAR_CLIENTE());
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}

	@DeleteMapping(value = "/deletar-cliente/{idCliente}")
	public ResponseEntity<String> deletarCliente(@PathVariable(value = "idCliente") Long idDoCliente) {
		try {
			clienteService.deletarCliente(idDoCliente);
			return ResponseEntity.ok(contantes.getSUCESSO_AO_TELETAR_CLIENTE());
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}

	@GetMapping(value = "/buscar-clientes/{idUsuario}")
	public ResponseEntity<List<Cliente>> buscarClientesDoUsuario(@PathVariable(value = "idUsuario") Long idDoUsuarioLogado) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(clienteService.buscarClientesDoUsuario(idDoUsuarioLogado));
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}