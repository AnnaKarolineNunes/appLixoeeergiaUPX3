package com.projeto.projetoupx3.model;

import com.projeto.projetoupx3.enumerator.TipoMaterial;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "materialReciclavel")
@NoArgsConstructor
@AllArgsConstructor
// Entidade que representa um material reciclável no sistema
public class MaterialReciclavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo_material", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMaterial tipoMaterial;

    @Column(name = "peso", nullable = false)
    private Double peso;

    // Construtor vazio necessário para JPA
    public MaterialReciclavel(Long id){
    }

    // Construtor para inicializar um material reciclável com nome, peso e tipo
    public MaterialReciclavel(String nome, Double peso, TipoMaterial tipoMaterial) {
        this.nome = nome;
        this.tipoMaterial = tipoMaterial;
        this.peso = peso;
    }

}
