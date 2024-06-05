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
public class PontoColetaDto {
    private Long id;

    @NotBlank(message = "o nome é obrigatório")
    private String nome;

    @NotBlank(message = "a localização é obrigatória")
    private String localizacao;

    public PontoColetaDto(PontoColeta pontoColeta){
        this.id = pontoColeta.getId();
        this.nome = pontoColeta.getNome();
        this.localizacao = pontoColeta.getLocalizacao();
    }

    public static PontoColeta convert(PontoColetaDto pontoColetaDto){
        PontoColeta pontoColeta = new PontoColeta(pontoColetaDto.getId());
        pontoColeta.setId(pontoColetaDto.getId());
        pontoColeta.setNome(pontoColetaDto.getNome());
        pontoColeta.setLocalizacao(pontoColetaDto.getLocalizacao());
        return pontoColeta;
    }
}
