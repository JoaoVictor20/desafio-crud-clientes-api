package com.projetos.desafio.models.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest {

    private Long idCliente;
    private Long idUsuario;
    private String telefone;
    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
}