package com.projeto.projetoupx3.restController;


import com.projeto.projetoupx3.model.Pesagem;
import com.projeto.projetoupx3.model.dtos.MaterialReciclavelDto;
import com.projeto.projetoupx3.model.dtos.PesagemDto;
import com.projeto.projetoupx3.services.MaterialReciclavelService;
import com.projeto.projetoupx3.services.PesagemService;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PesagemController {

    @Autowired
    PesagemService pesagemService;

    @GetMapping("/pesagem")
    public ApiResponse<List<PesagemDto>> findAll() {
        return this.pesagemService.findAll();
    }

    @GetMapping("pesagem/{id}")
    public ApiResponse<PesagemDto> findById(@PathVariable Long id) {
        return this.pesagemService.findById(id);
    }
    @PostMapping("/calcularPesagem")
    public ApiResponse<Double> calcularPesoTotal(@RequestBody List<Long> idsMateriais) {
        return pesagemService.calcularPesoTotal(idsMateriais);
    }

    @PostMapping("/salvarPesagem")
    public ApiResponse<Void> salvarPesagem(@RequestBody Pesagem pesagem) {
        return pesagemService.salvarPesagem(pesagem);
    }

    @DeleteMapping("pesagem/{id}")
    public ApiResponse<Void> deleteById(@PathVariable Long id) {
        // Implementar se necessário
        return new ApiResponse<>(404, "Endpoint não implementado", null);
    }
}
