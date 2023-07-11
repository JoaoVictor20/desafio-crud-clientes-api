package com.projetos.desafio.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "cliente_fisico")
@PrimaryKeyJoinColumn(name = "id_cliente_fisico")
public class Fisica extends Cliente implements Serializable, Cloneable {

	@Temporal(TemporalType.DATE)
    private Date dataDeNascimento;
	
	@Column(nullable=false)
    private String cpf;
	
	@Column(nullable=false)
    private String nome;
}