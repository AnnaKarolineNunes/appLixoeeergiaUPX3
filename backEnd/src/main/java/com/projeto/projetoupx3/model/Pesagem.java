package com.projeto.projetoupx3.model;

import com.projeto.projetoupx3.enumerator.TipoMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa uma pesagem de materiais recicláveis.
 * <p>
 * Esta classe mapeia a entidade "pesagem" no banco de dados, armazenando
 * informações sobre o material reciclável e o peso total da pesagem.
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "pesagem")
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

    public Pesagem(Long id) {
    }

    public Pesagem(Long id, MaterialReciclavel materialReciclavel, Double pesoTotal) {
        this.id = id;
        this.materialReciclavel = materialReciclavel;
        this.pesoTotal = pesoTotal;
    }

}
