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

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private TipoMaterial tipoMaterial;

    public MaterialReciclavelDto(MaterialReciclavel materialReciclavel) {
        this.id = materialReciclavel.getId();
        this.nome = materialReciclavel.getNome();
        this.tipoMaterial = materialReciclavel.getTipoMaterial();
    }

    public static MaterialReciclavel convert(MaterialReciclavelDto materialReciclavelDto) {
        MaterialReciclavel materialReciclavel = new MaterialReciclavel(materialReciclavelDto.getId());
        materialReciclavel.setId(materialReciclavelDto.getId());
        materialReciclavel.setNome(materialReciclavelDto.getNome());
        materialReciclavel.setTipoMaterial(materialReciclavelDto.getTipoMaterial());
        return materialReciclavel;
    }
}
