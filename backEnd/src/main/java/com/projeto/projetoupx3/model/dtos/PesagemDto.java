package com.projeto.projetoupx3.model.dtos;

import com.projeto.projetoupx3.model.*;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PesagemDto {

    private Long id;
    private Long materialReciclavel;

    @NotBlank(message = "O nome é obrigatório")
    private Double pesoTotal;


    public PesagemDto(Pesagem pesagem){
        this.id = pesagem.getId();
        this.materialReciclavel = pesagem.getMaterialReciclavel().getIdMaterial();
        this.pesoTotal = pesagem.getPesoTotal();
    }

    public static Pesagem convert(PesagemDto pesagemDto){
        Pesagem pesagem = new Pesagem();
        pesagem.setId(pesagemDto.getId());
        pesagem.setMaterialReciclavel(pesagemDto.getMaterialReciclavel());
        pesagem.setPesoTotal(pesagemDto.getPesoTotal());
        return pesagem;
    }

}
