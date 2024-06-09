package com.projeto.projetoupx3.services;
import com.projeto.projetoupx3.model.PontoColeta;
import com.projeto.projetoupx3.model.dtos.PontoColetaDto;
import com.projeto.projetoupx3.repositories.PontoColetaRepository;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PontoColetaService {

    @Autowired
    PontoColetaRepository pontoColetaRepository;

    /**
     * Retorna todos os materiais recicláveis do banco de dados.
     * @return ApiResponse contendo a lista de materiais recicláveis ou mensagem de erro.
     */
    public ApiResponse<List<PontoColetaDto>> findAll(){
        try {
            List<PontoColeta> pontoColetas = this.pontoColetaRepository.findAll();
            return new ApiResponse<>(200, "Listagem de pontos de coleta realizada com sucesso!",
                    pontoColetas.stream().map(PontoColetaDto::new).collect(Collectors.toList()));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Retorna um ponto de coleta pelo seu ID.
     *
     * @param id ID do ponto de coleta a ser buscado.
     * @return ApiResponse contendo o ponto de coleta encontrado ou mensagem de erro.
     */
    public ApiResponse<PontoColetaDto> findById(Long id) {
        try {
            Optional<PontoColeta> resultado = this.pontoColetaRepository.findById(id);

            return resultado.map(pontoColeta -> new ApiResponse<>(200, "Detalhamento de ponto de coleta realizado com sucesso!",
                    new PontoColetaDto(pontoColeta))).orElseGet(() -> new ApiResponse<>(204, "Ponto de coleta não encontrado!", null));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Obtém a lista de pontos de coleeta definida internamente e a insere no banco de dados,
     * verificando antes se os pontos já existem.
     * @return ApiResponse indicando o sucesso ou falha da operação de inserção.
     */
    public ApiResponse<List<PontoColeta>> getPontosDeColeta() {
        try {
            List<PontoColeta> pontoColetas = Arrays.asList(
                    new PontoColeta("Estação Centro-Sul", "Parque Juscelino Kubistchek"),
                    new PontoColeta("Estação leste", "Parque Linear do Vale do Arrudas"),
                    new PontoColeta("Estação Nordeste", "Parque Ecologico Jardim Vitória"),
                    new PontoColeta("Estação Norte", "Parque Jardim das Nascentes"),
                    new PontoColeta("Estação Oeste", "Parque Ecologico Pedro Machado"),
                    new PontoColeta("Estação Pampulha", "Parque Enseada das Garças"),
                    new PontoColeta("Estação Venda Nova", "Parque José Lopes dos Reis"),
                    new PontoColeta("Estação Barreiro", "Parque Ecologico Padre Alfredo Sabetta")
                    );

            ApiResponse<Void> insercaoResponse = inserirPontosDeColeta(pontoColetas);
            if (insercaoResponse.getStatus() != 200) {
                return new ApiResponse<>(500, "Erro ao inserir materiais recicláveis.", null);
            }
            return new ApiResponse<>(200, "Listagem de materiais recicláveis realizada com sucesso!", pontoColetas);
        } catch (Exception e) {
            return new ApiResponse<>(500, "Erro ao listar materiais recicláveis: " + e.getMessage(), null);
        }
    }

    /**
     * Insere os pontos de coleta fornecidos no banco de dados,
     * verificando antes se eles já existem.
     * @param pontoColetas Lista de pontos de coleta a serem inseridos.
     * @return ApiResponse indicando o sucesso ou falha da operação de inserção.
     */
    public ApiResponse<Void> inserirPontosDeColeta(List<PontoColeta> pontoColetas) {
        try {
            for (PontoColeta pontoColeta : pontoColetas) {
                if (!pontoExistsByNome(pontoColeta.getNome())) {
                    pontoColetaRepository.save(pontoColeta);
                }
            }
            return new ApiResponse<>(200, "Materiais inseridos com sucesso!", null);
        } catch (Exception e) {
            return new ApiResponse<>(500, "Erro ao inserir materiais recicláveis: " + e.getMessage(), null);
        }
    }



    /**
     * Verifica se um ponto de coleta com o nome especificado já existe no banco de dados.
     * @param nome Nome do ponto de coleta a ser verificado.
     * @return true se o ponto de coleta existir, false caso contrário.
     */
    public boolean pontoExistsByNome(String nome) {
        return pontoColetaRepository.existsByNome(nome);
    }
}
