package com.projeto.projetoupx3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuario")
// Entidade que representa um usuário no sistema
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 100)
    private String sobrenome;

    @Column
    private String email;

    @Column(length = 30)
    private String senha;

    // Construtor vazio necessário para JPA
    public Usuario(Long id) {
    }
}
