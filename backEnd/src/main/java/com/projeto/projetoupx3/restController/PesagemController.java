package com.projeto.projetoupx3.restController;

import com.projeto.projetoupx3.model.Pesagem;
import com.projeto.projetoupx3.model.dtos.PesagemDto;
import com.projeto.projetoupx3.services.PesagemService;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("/pesagem")
// Controlador REST para operações relacionadas a pesagens de materiais recicláveis
public class PesagemController {

    @Autowired
    PesagemService pesagemService;

    /**
     * Endpoint para buscar todas as pesagens de materiais recicláveis.
     * GET /pesagem
     * @return ApiResponse contendo a lista de pesagens encontradas
     */
    @GetMapping
    public ApiResponse<List<PesagemDto>> findAll() {
        return this.pesagemService.findAll();
    }

    /**
     * Endpoint para buscar uma pesagem por ID.
     * GET /pesagem/{id}
     * @param id ID da pesagem a ser buscada.
     * @return ApiResponse contendo a pesagem encontrada
     */
    @GetMapping("/{id}")
    public ApiResponse<PesagemDto> findById(@PathVariable Long id) {
        return this.pesagemService.findById(id);
    }

    /**
     * Endpoint para calcular o peso total de uma lista de materiais recicláveis.
     * POST /pesagem/calcular-peso-total
     * @param idsMateriais Lista de IDs dos materiais recicláveis para calcular o peso total.
     * @return ApiResponse contendo o peso total calculado
     */
    @PostMapping("/calcular-peso-total")
    public ApiResponse<Double> calcularPesagem(@RequestBody List<Long> idsMateriais) {
        ApiResponse<Double> response = this.pesagemService.calcularPesoTotal(idsMateriais);

        if (response.getStatus() == 200 && response.getData() != null) {
            // Arredondando para duas casas decimais diretamente no valor
            double pesoTotal = Math.round(response.getData() * 100.0) / 100.0;

            // Atualizando o valor arredondado no response
            response.setData(pesoTotal);
        }

        return response;
    }

    /**
     * Endpoint para salvar uma nova pesagem.
     * POST /pesagem/salvar
     * @param pesagemDto Objeto contendo os dados da pesagem a ser salva.
     * @return ApiResponse indicando o resultado da operação de salvamento
     */
    @PostMapping("/salvar")
    public ApiResponse<Void> salvarPesagem(@RequestBody PesagemDto pesagemDto) {
        return pesagemService.salvarPesagem(pesagemDto);
    }

    /**
     * Endpoint para deletar uma pesagem por ID.
     * DELETE /pesagem/{id}
     * @param id ID da pesagem a ser deletada.
     * @return ApiResponse indicando o resultado da operação de deleção
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        return pesagemService.deleteById(id);
    }

    /**
     * Endpoint para calcular e atualizar o desconto de uma pesagem específica.
     * POST /pesagem/{id}/calcular-desconto
     * @param id ID da pesagem para calcular o desconto.
     * @return ApiResponse indicando o sucesso ou falha da operação de cálculo de desconto.
     */
    @PostMapping("/{id}/calcular-desconto")
    public ApiResponse<Void> calcularEAtualizarDesconto(@PathVariable Long id) {
        return pesagemService.calcularEAtualizarDesconto(id);
    }

    /**
     * Endpoint para obter o desconto de uma pesagem específica.
     * GET /pesagem/{id}/desconto
     * @param id ID da pesagem para recuperar o desconto.
     * @return ApiResponse contendo o desconto da pesagem ou mensagem de erro.
     */
    @GetMapping("/{id}/desconto")
    public ApiResponse<Double> obterDesconto(@PathVariable Long id) {
        return pesagemService.obterDesconto(id);
    }

    /**
     * Endpoint para obter o peso total de uma pesagem por ID.
     * GET /pesagem/pesoTotal/{id}
     * @param id ID da pesagem para recuperar o peso total.
     * @return ApiResponse contendo o peso total da pesagem ou mensagem de erro.
     */
    @GetMapping("/pesoTotal/{id}")
    public ApiResponse<Double> getPesoTotalById(@PathVariable Long id) {
        return pesagemService.getPesoTotalById(id);
    }
}
