package com.projetos.desafio.util;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Constantes {

	public final String SUCESSO_AO_SALVAR_CLIENTE = "Cliente salvo com sucesso.";
	public final String SUCESSO_AO_ALTERAR_CLIENTE = "Cliente alterado com sucesso.";
	public final String SUCESSO_AO_TELETAR_CLIENTE = "Cliente deletado com sucesso.";

	public final String ERRO_AO_SALVAR_CLIENTE = "Erro ao cadastrar cliente. Verifique se todos os campos obrigatórios estão preenchidos corretamente.";
	public final String ERRO_AO_ALTERAR_CLIENTE = "Erro ao alterar cliente. Verifique se todos os campos obrigatórios estão preenchidos corretamente.";
	public final String ERRO_AO_DELETAR_CLIENTE = "Erro ao deletar cliente.";
	public final String ERRO_AO_LISTAR_CLIENTES = "Erro ao listar clientes.";

	public final String NOME_PROJETO = "desafio";
	public final String ERRO_AO_GERAR_TOKEN = "Erro ao gerar o token.";
	public final String ERRO_AO_VALIDAR_TOKEN = "Erro ao validar o token.";
	public final String TIME_ZONE_BRASILIA = "-03:00";
	public final String FORMATO_PADRAO_DE_DATA = "dd/MM/yyyy";
}