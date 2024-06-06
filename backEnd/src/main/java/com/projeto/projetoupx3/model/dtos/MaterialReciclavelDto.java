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
public class MaterialReciclavelDto {

    private Long idMaterial;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private TipoMaterial tipoMaterial;

    private Double peso;

    public MaterialReciclavelDto(MaterialReciclavel materialReciclavel) {
        this.idMaterial = materialReciclavel.getIdMaterial();
        this.nome = materialReciclavel.getNome();
        this.tipoMaterial = materialReciclavel.getTipoMaterial();
        this.peso = materialReciclavel.getPeso();
    }

    public static MaterialReciclavel convert(MaterialReciclavelDto materialReciclavelDto) {
        MaterialReciclavel materialReciclavel = new MaterialReciclavel(materialReciclavelDto.getIdMaterial());
        materialReciclavel.setIdMaterial(materialReciclavelDto.getIdMaterial());
        materialReciclavel.setNome(materialReciclavelDto.getNome());
        materialReciclavel.setTipoMaterial(materialReciclavelDto.getTipoMaterial());
        materialReciclavel.setPeso(materialReciclavelDto.getPeso());
        return materialReciclavel;
    }
}