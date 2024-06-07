package com.projeto.projetoupx3.restController;


import com.projeto.projetoupx3.model.Pesagem;
import com.projeto.projetoupx3.model.dtos.MaterialReciclavelDto;
import com.projeto.projetoupx3.model.dtos.PesagemDto;
import com.projeto.projetoupx3.services.MaterialReciclavelService;
import com.projeto.projetoupx3.services.PesagemService;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("/pesagem")
public class PesagemController {

    @Autowired
    PesagemService pesagemService;

    @GetMapping
    public ApiResponse<List<PesagemDto>> findAll() {
        return this.pesagemService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponse<PesagemDto> findById(@PathVariable Long id) {
        return this.pesagemService.findById(id);
    }
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

    @PostMapping("/salvar")
    public ApiResponse<Void> salvarPesagem(@RequestBody PesagemDto pesagemDto) {
        return pesagemService.salvarPesagem(pesagemDto);
    }


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

    @GetMapping("/pesoTotal/{id}")
    public ApiResponse<Double> getPesoTotalById(@PathVariable Long id) {
        return pesagemService.getPesoTotalById(id);
    }


}
