package com.projeto.projetoupx3.services;


import com.projeto.projetoupx3.model.PontoColeta;
import com.projeto.projetoupx3.model.dtos.PontoColetaDto;
import com.projeto.projetoupx3.repositories.PontoColetaRepository;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontoColetaService {

    @Autowired
    PontoColetaRepository pontoColetaRepository;

    public ApiResponse<List<PontoColetaDto>> findAll(){
        try {
            List<PontoColeta> pontoColetas = this.pontoColetaRepository.findAll();
            return new ApiResponse<>(200, "Listagem de prioridades realizada com sucesso!",
                    pontoColetas.stream().map(PontoColetaDto::new).collect(Collectors.toList()));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    // Método para inicializar a lista de pontos de coleta existentes
    public ApiResponse<List<PontoColeta>> getPontosDeColetaExistentes() {
        try {
            List<PontoColeta> pontosDeColeta = new ArrayList<>();
            // Adicionar pontos de coleta manualmente
            pontosDeColeta.add(new PontoColeta("Estação Zona Sul", "Endereço 1"));
            pontosDeColeta.add(new PontoColeta("Estação Zona Norte", "Endereço 2"));
            pontosDeColeta.add(new PontoColeta("Estação Zona Oeste", "Endereço 2"));
            pontosDeColeta.add(new PontoColeta("Estação Zona Leste", "Endereço 2"));
            pontosDeColeta.add(new PontoColeta("Estação Zona Sudoeste", "Endereço 2"));
            pontosDeColeta.add(new PontoColeta("Estação Zona Nordeste", "Endereço 2"));
            pontosDeColeta.add(new PontoColeta("Estação Zona Noroeste", "Endereço 2"));
            pontosDeColeta.add(new PontoColeta("Estação Zona Sudoeste", "Endereço 2"));
            return new ApiResponse<>(200, "Pontos de coleta listados com sucesso!", pontosDeColeta);
        } catch (Exception e) {
            return new ApiResponse<>(500, "Erro ao listar pontos de coleta: " + e.getMessage(), null);
        }
    }
}
