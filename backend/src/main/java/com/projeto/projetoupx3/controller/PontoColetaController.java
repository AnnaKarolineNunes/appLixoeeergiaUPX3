package com.projeto.projetoupx3.controller;


import com.projeto.projetoupx3.model.dtos.PontoColetaDto;
import com.projeto.projetoupx3.services.PontoColetaService;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PontoColetaController {
    @Autowired
    PontoColetaService pontoColetaService;

    @GetMapping("/setores")
    public ApiResponse<List<PontoColetaDto>> findAll() {
        return this.pontoColetaService.findAll();
    }

    @GetMapping("/pontoColetas")
    public ApiResponse<List<PontoColetaDto>> getAllPontosColeta() {
        return pontoColetaService.findAll();
    }
}
