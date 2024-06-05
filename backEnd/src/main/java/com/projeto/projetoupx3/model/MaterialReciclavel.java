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
public class MaterialReciclavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMaterial tipoMaterial;

    public MaterialReciclavel(Long id){
    }

    public MaterialReciclavel(String nome, TipoMaterial tipoMaterial) {
        this.nome = nome;
        this.tipoMaterial = tipoMaterial;
    }

}
