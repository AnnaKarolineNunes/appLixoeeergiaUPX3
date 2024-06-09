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
// Entidade que representa um ponto de coleta no sistema
public class PontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String localizacao;

    // Construtor vazio necessário para JPA
    public PontoColeta(Long id) {
    }

    // Construtor para inicializar um ponto de coleta com nome e localização
    public PontoColeta(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }
}
