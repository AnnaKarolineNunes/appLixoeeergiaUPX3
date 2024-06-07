package com.projeto.projetoupx3.model.dtos;

import com.projeto.projetoupx3.model.PontoColeta;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// DTO (Data Transfer Object) que representa um ponto de coleta para transferência de dados entre camadas
public class PontoColetaDto {
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "A localização é obrigatória")
    private String localizacao;

    // Construtor que converte um objeto PontoColeta para PontoColetaDto
    public PontoColetaDto(PontoColeta pontoColeta){
        this.id = pontoColeta.getId();
        this.nome = pontoColeta.getNome();
        this.localizacao = pontoColeta.getLocalizacao();
    }

    // Método estático para converter PontoColetaDto para PontoColeta
    public static PontoColeta convert(PontoColetaDto pontoColetaDto){
        PontoColeta pontoColeta = new PontoColeta(pontoColetaDto.getId());
        pontoColeta.setId(pontoColetaDto.getId());
        pontoColeta.setNome(pontoColetaDto.getNome());
        pontoColeta.setLocalizacao(pontoColetaDto.getLocalizacao());
        return pontoColeta;
    }
}
