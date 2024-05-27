package com.projeto.projetoupx3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "pontoColeta")
@Entity
public class PontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPontoColeta;

    @Column
    private String nome;

    @Column
    private String localizacao;

}
