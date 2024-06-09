package com.projeto.projetoupx3.restController;

import com.projeto.projetoupx3.model.PontoColeta;
import com.projeto.projetoupx3.model.dtos.PontoColetaDto;
import com.projeto.projetoupx3.services.PontoColetaService;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Controlador REST para operações relacionadas a pontos de coleta
public class PontoColetaController {

    @Autowired
    PontoColetaService pontoColetaService;

    /**
     * Endpoint para buscar todos os pontos de coleta.
     * GET /pontosdecoleta
     * @return ApiResponse contendo a lista de pontos de coleta encontrados
     */
    @GetMapping("/pontosdecoleta")
    public ApiResponse<List<PontoColetaDto>> findAll() {
        return this.pontoColetaService.findAll();
    }

    /**
     * Endpoint para buscar um ponto de coleta por ID.
     * GET /pontosdecoleta/{id}
     * @param id ID do ponto de coleta a ser buscado.
     * @return ApiResponse contendo o ponto de coleta encontrado
     */
    @GetMapping("/pontosdecoleta/{id}")
    public ApiResponse<PontoColetaDto> findById(@PathVariable Long id) {
        return this.pontoColetaService.findById(id);
    }

    /**
     * Endpoint para inserir a lista de pontos de coleta no banco de dados.
     * GET /inserirListaDePontosDeColeta
     * @return ApiResponse contendo a lista de pontos de coleta inseridos
     */
    @GetMapping("/inserirListaDePontosDeColeta")
    public ApiResponse<List<PontoColeta>> inserirPontosDeColeta() {
        return this.pontoColetaService.getPontosDeColeta();
    }

    /**
     * Endpoint para atualizar um ponto de coleta por ID.
     * PUT /pontosdecoleta/{id}
     * @param id ID do ponto de coleta a ser atualizado.
     * @param dto Objeto contendo os novos dados do ponto de coleta.
     * @return ApiResponse contendo o ponto de coleta atualizado
     */
    @PutMapping("/pontosdecoleta/{id}")
    public ApiResponse<PontoColetaDto> updateById(@PathVariable Long id, @RequestBody PontoColetaDto dto) {
        // Implementar se necessário
        return new ApiResponse<>(404, "Endpoint não implementado", null);
    }

    /**
     * Endpoint para deletar um ponto de coleta por ID.
     * DELETE /pontosdecoleta/{id}
     * @param id ID do ponto de coleta a ser deletado.
     * @return ApiResponse indicando o resultado da operação de deleção
     */
    @DeleteMapping("/pontosdecoleta/{id}")
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        // Implementar se necessário
        return new ApiResponse<>(404, "Endpoint não implementado", null);
    }
}
