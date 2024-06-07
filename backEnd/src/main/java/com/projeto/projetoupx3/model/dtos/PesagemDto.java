package com.projeto.projetoupx3.model.dtos;

import com.projeto.projetoupx3.model.*;

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
    private Long materialReciclavel; // Note que aqui é o ID do MaterialReciclavel
    private Double pesoTotal;
    private Double desconto;


    public PesagemDto(Pesagem pesagem){
        this.id = pesagem.getId();
        this.materialReciclavel = pesagem.getMaterialReciclavel().getId();
        this.pesoTotal = pesagem.getPesoTotal();
        this.desconto = pesagem.getDesconto();
    }

    // Método estático para converter PesagemDto para Pesagem
    public static Pesagem convert(PesagemDto pesagemDto, MaterialReciclavel materialReciclavel) {
        Pesagem pesagem = new Pesagem();
        pesagem.setId(pesagemDto.getId());
        pesagem.setMaterialReciclavel(materialReciclavel); // Define o MaterialReciclavel encontrado pelo ID
        pesagem.setPesoTotal(pesagemDto.getPesoTotal());
        pesagem.setDesconto(pesagemDto.getDesconto());
        return pesagem;
    }

}
