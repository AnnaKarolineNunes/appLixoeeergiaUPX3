package com.projeto.projetoupx3.model.dtos;

import com.projeto.projetoupx3.enumerator.TipoMaterial;
import com.projeto.projetoupx3.model.MaterialReciclavel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// DTO (Data Transfer Object) que representa um material reciclável para transferência de dados entre camadas
public class MaterialReciclavelDto {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private TipoMaterial tipoMaterial;

    private Double peso;

    // Construtor que converte um objeto MaterialReciclavel para MaterialReciclavelDto
    public MaterialReciclavelDto(MaterialReciclavel materialReciclavel) {
        this.id = materialReciclavel.getId();
        this.nome = materialReciclavel.getNome();
        this.tipoMaterial = materialReciclavel.getTipoMaterial();
        this.peso = materialReciclavel.getPeso();
    }

    // Método estático para converter MaterialReciclavelDto para MaterialReciclavel
    public static MaterialReciclavel convert(MaterialReciclavelDto materialReciclavelDto) {
        MaterialReciclavel materialReciclavel = new MaterialReciclavel(materialReciclavelDto.getId());
        materialReciclavel.setId(materialReciclavelDto.getId());
        materialReciclavel.setNome(materialReciclavelDto.getNome());
        materialReciclavel.setTipoMaterial(materialReciclavelDto.getTipoMaterial());
        materialReciclavel.setPeso(materialReciclavelDto.getPeso());
        return materialReciclavel;
    }
}
