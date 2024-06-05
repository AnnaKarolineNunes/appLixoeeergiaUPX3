package com.projeto.projetoupx3.restController;

import com.projeto.projetoupx3.model.dtos.UsuarioDto;
import com.projeto.projetoupx3.services.UsuarioService;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
        @Autowired
        private UsuarioService usuarioService;

        @PostMapping("/usuarios")
        public ApiResponse<UsuarioDto> save(@RequestBody UsuarioDto dto) {
                return this.usuarioService.save(dto);
        }

        @GetMapping("/usuarios")
        public ApiResponse<List<UsuarioDto>> findAll() {
                return this.usuarioService.findAll();
        }

        @GetMapping("usuarios/{id}")
        public ApiResponse<UsuarioDto> findById(@PathVariable Long id) {
                return this.usuarioService.findById(id);
        }

        @PutMapping("/usuarios/{id}")
        public ApiResponse<UsuarioDto> updateById(@PathVariable Long id, @RequestBody UsuarioDto dto) {
                return this.usuarioService.updateById(id, dto);
        }

        @DeleteMapping("/usuarios/{id}")
        public ApiResponse<UsuarioDto> deleteById(@PathVariable Long id) {
                return this.usuarioService.deleteById(id);
        }

}
