package com.projeto.projetoupx3.restController;

import com.projeto.projetoupx3.model.MaterialReciclavel;
import com.projeto.projetoupx3.model.dtos.MaterialReciclavelDto;
import com.projeto.projetoupx3.services.MaterialReciclavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projeto.projetoupx3.shared.ApiResponse;
import java.util.List;

@RestController
public class MaterialReciclavelController {

    @Autowired
    MaterialReciclavelService materialReciclavelService;

    /**
     * Endpoint para buscar todos os materiais recicláveis.
     * GET /materiaisReciclaveis
     */
    @GetMapping("/materiaisReciclaveis")
    public ApiResponse<List<MaterialReciclavelDto>> findAll() {
        return this.materialReciclavelService.findAll();
    }

    /**
     * Endpoint para buscar um material reciclável por ID.
     * GET /materiaisReciclaveis/{id}
     * @param id ID do material reciclável a ser buscado.
     */
    @GetMapping("materiaisReciclaveis/{id}")
    public ApiResponse<MaterialReciclavelDto> findById(@PathVariable Long id) {
        return this.materialReciclavelService.findById(id);
    }

    /**
     * Endpoint para inserir a lista de materiais recicláveis no banco de dados.
     * GET /inserirLista
     */
    @GetMapping("/inserirLista")
    public ApiResponse<List<MaterialReciclavel>> inserirListaMateriais() {
        return this.materialReciclavelService.getMateriaisReciclaveis();
    }

    /**
     * Endpoint para atualizar um material reciclável por ID.
     * PUT /materiaisReciclaveis/{id}
     * @param id ID do material reciclável a ser atualizado.
     * @param dto Objeto contendo os novos dados do material reciclável.
     */

    /**
     * Endpoint para deletar um material reciclável por ID.
     * DELETE /materiaisReciclaveis/{id}
     * @param id ID do material reciclável a ser deletado.
     */
    @DeleteMapping("materiaisReciclaveis/{id}")
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        // Implementar se necessário
        return new ApiResponse<>(404, "Endpoint não implementado", null);
    }

    @PutMapping("/{id}")
    public ApiResponse<MaterialReciclavelDto> updateById(@PathVariable Long id, @RequestBody MaterialReciclavelDto dto) {
        return materialReciclavelService.updateById(id, dto);
    }
}
