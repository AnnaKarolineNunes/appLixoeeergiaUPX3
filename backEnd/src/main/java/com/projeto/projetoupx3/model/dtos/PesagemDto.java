package com.projeto.projetoupx3.model.dtos;

import com.projeto.projetoupx3.model.MaterialReciclavel;
import com.projeto.projetoupx3.model.Pesagem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// DTO (Data Transfer Object) que representa uma pesagem para transferência de dados entre camadas
public class PesagemDto {

    private Long id;
    private Long materialReciclavel; // ID do MaterialReciclavel associado à pesagem
    private Double pesoTotal;
    private Double desconto;

    // Construtor que converte um objeto Pesagem para PesagemDto
    public PesagemDto(Pesagem pesagem){
        this.id = pesagem.getId();
        this.materialReciclavel = pesagem.getMaterialReciclavel().getId();
        this.pesoTotal = pesagem.getPesoTotal();
        this.desconto = pesagem.getDesconto();
    }

    // Método estático para converter PesagemDto para Pesagem, utilizando o MaterialReciclavel fornecido
    public static Pesagem convert(PesagemDto pesagemDto, MaterialReciclavel materialReciclavel) {
        Pesagem pesagem = new Pesagem();
        pesagem.setId(pesagemDto.getId());
        pesagem.setMaterialReciclavel(materialReciclavel); // Define o MaterialReciclavel encontrado pelo ID
        pesagem.setPesoTotal(pesagemDto.getPesoTotal());
        pesagem.setDesconto(pesagemDto.getDesconto());
        return pesagem;
    }

}
