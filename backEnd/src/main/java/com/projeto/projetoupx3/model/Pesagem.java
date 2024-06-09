package com.projeto.projetoupx3.model;

import com.projeto.projetoupx3.enumerator.TipoMaterial;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "pesagem")
// Entidade que representa uma pesagem de materiais recicláveis
public class Pesagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idMaterial", nullable = false)
    private MaterialReciclavel materialReciclavel;

    @Column(name = "peso_total", nullable = false)
    private Double pesoTotal;

    @Column(name = "desconto")
    private Double desconto;

    // Construtor vazio necessário para JPA
    public Pesagem(Long id) {
    }

    // Construtor para inicializar uma pesagem com todos os atributos
    public Pesagem(Long id, MaterialReciclavel materialReciclavel, Double pesoTotal, Double desconto) {
        this.id = id;
        this.materialReciclavel = materialReciclavel;
        this.pesoTotal = pesoTotal;
        this.desconto = desconto;
    }
}
