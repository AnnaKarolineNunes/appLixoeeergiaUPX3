package com.projeto.projetoupx3.model.dtos;

import com.projeto.projetoupx3.model.PontoColeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class PontoColetaDto {
    private int id;
    private String nome;
    private String localizacao;

    public PontoColetaDto(int id) {
        this.id = id;
    }

    public PontoColetaDto(){}

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
