package com.projeto.projetoupx3.controller;

import com.projeto.projetoupx3.model.dtos.AuthDto;
import com.projeto.projetoupx3.model.dtos.UsuarioDto;
import com.projeto.projetoupx3.services.UsuarioService;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class AuthController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastra-usuario")
    public String register(@ModelAttribute UsuarioDto dto, Model model) {
        ApiResponse<UsuarioDto> usuarioCadastrado = this.usuarioService.save(dto);

        if(usuarioCadastrado.getData() == null) {
            model.addAttribute("erro", usuarioCadastrado.getMessage());
            return "cadastro";
        }

        return "redirect:/login";
    }

    @PostMapping("/login-usuario")
    public String login(@ModelAttribute AuthDto dto, Model model) {
        ApiResponse<UsuarioDto> usuarioLogado = this.usuarioService.login(dto);

        if (usuarioLogado.getData() == null) {
            model.addAttribute("erro", usuarioLogado.getMessage());
            return "login";
        }
        return "homepage";
    }
}