package com.projeto.projetoupx3.restController;

import com.projeto.projetoupx3.model.dtos.UsuarioDto;
import com.projeto.projetoupx3.services.UsuarioService;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Controlador REST para operações relacionadas a usuários
public class UsuarioController {

        @Autowired
        private UsuarioService usuarioService;

        /**
         * Endpoint para salvar um novo usuário.
         * POST /usuarios
         * @param dto Objeto contendo os dados do usuário a ser salvo.
         * @return ApiResponse contendo o usuário salvo.
         */
        @PostMapping("/usuarios")
        public ApiResponse<UsuarioDto> save(@RequestBody UsuarioDto dto) {
                return this.usuarioService.save(dto);
        }

        /**
         * Endpoint para buscar todos os usuários.
         * GET /usuarios
         * @return ApiResponse contendo a lista de usuários encontrados.
         */
        @GetMapping("/usuarios")
        public ApiResponse<List<UsuarioDto>> findAll() {
                return this.usuarioService.findAll();
        }

        /**
         * Endpoint para buscar um usuário por ID.
         * GET /usuarios/{id}
         * @param id ID do usuário a ser buscado.
         * @return ApiResponse contendo o usuário encontrado.
         */
        @GetMapping("/usuarios/{id}")
        public ApiResponse<UsuarioDto> findById(@PathVariable Long id) {
                return this.usuarioService.findById(id);
        }

        /**
         * Endpoint para atualizar um usuário por ID.
         * PUT /usuarios/{id}
         * @param id ID do usuário a ser atualizado.
         * @param dto Objeto contendo os novos dados do usuário.
         * @return ApiResponse contendo o usuário atualizado.
         */
        @PutMapping("/usuarios/{id}")
        public ApiResponse<UsuarioDto> updateById(@PathVariable Long id, @RequestBody UsuarioDto dto) {
                return this.usuarioService.updateById(id, dto);
        }

        /**
         * Endpoint para deletar um usuário por ID.
         * DELETE /usuarios/{id}
         * @param id ID do usuário a ser deletado.
         * @return ApiResponse contendo o usuário deletado.
         */
        @DeleteMapping("/usuarios/{id}")
        public ApiResponse<UsuarioDto> deleteById(@PathVariable Long id) {
                return this.usuarioService.deleteById(id);
        }
}
