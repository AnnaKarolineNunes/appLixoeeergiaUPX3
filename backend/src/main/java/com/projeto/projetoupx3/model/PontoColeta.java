package com.projeto.projetoupx3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pontoColeta")
public class PontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String localizacao;

    public PontoColeta(int id) {
    }

    public PontoColeta(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }
}
