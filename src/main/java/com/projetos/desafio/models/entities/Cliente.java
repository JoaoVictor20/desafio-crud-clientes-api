package com.projetos.desafio.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario = new Usuario();

    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date dataCadastro;
    
    @Temporal(TemporalType.DATE)
    private Date dataAlteracao;
    private String telefone;
}