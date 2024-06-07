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


}
