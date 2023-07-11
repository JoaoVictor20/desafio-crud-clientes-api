package com.projetos.desafio.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "cliente_juridico")
@PrimaryKeyJoinColumn(name = "id_cliente_juridico")
public class Juridica extends Cliente implements Serializable, Cloneable {

	@Column(nullable=false)
    private String cnpj;
	
	@Column(nullable=false)
    private String razaoSocial;
	
    private String nomeFantasia;
}