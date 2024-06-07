package com.projeto.projetoupx3.services;

import com.projeto.projetoupx3.model.Usuario;
import com.projeto.projetoupx3.model.dtos.AuthDto;
import com.projeto.projetoupx3.model.dtos.UsuarioDto;
import com.projeto.projetoupx3.repositories.UsuarioRepository;
import com.projeto.projetoupx3.shared.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Serviço para operações relacionadas aos usuários.
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Salva um novo usuário.
     *
     * @param dto DTO contendo os dados do usuário a ser salvo.
     * @return ApiResponse com o resultado da operação.
     */
    public ApiResponse<UsuarioDto> save(UsuarioDto dto) {
        try {
            // Verifica se já existe um usuário com o mesmo email
            if (usuarioRepository.existByEmail(dto.getEmail())) {
                return new ApiResponse<>(409, "Já existe outro usuário com esse email!", null);
            }

            // Verifica se as senhas coincidem
            if (!Objects.equals(dto.getSenha(), dto.getConfirmaSenha())) {
                return new ApiResponse<>(400, "As senhas digitadas não coincidem. Por favor, verifique e tente novamente", null);
            }

            // Converte DTO para entidade Usuario e salva no banco de dados
            Usuario usuario = UsuarioDto.convert(dto);
            usuario = usuarioRepository.save(usuario);

            return new ApiResponse<>(201, "Usuário cadastrado com sucesso!", new UsuarioDto(usuario));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Realiza o login do usuário.
     *
     * @param dto DTO contendo email e senha para o login.
     * @return ApiResponse com o resultado do login.
     */
    public ApiResponse<UsuarioDto> login(AuthDto dto) {
        try {
            // Busca o usuário pelo email
            Optional<Usuario> existeUsuario = usuarioRepository.findByEmail(dto.getEmail());

            // Verifica se o usuário existe e se a senha está correta
            if (existeUsuario.isEmpty() || !existeUsuario.get().getSenha().equals(dto.getSenha())) {
                return new ApiResponse<>(400, "Usuário ou senha inválida!", null);
            }

            return new ApiResponse<>(200, "Login realizado com sucesso!", new UsuarioDto(existeUsuario.get()));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Retorna todos os usuários cadastrados.
     *
     * @return ApiResponse contendo a lista de todos os usuários.
     */
    public ApiResponse<List<UsuarioDto>> findAll() {
        try {
            // Busca todos os usuários no banco de dados
            List<Usuario> usuarios = usuarioRepository.findAll();
            // Converte a lista de entidades Usuario para DTO UsuarioDto
            List<UsuarioDto> usuarioDtos = usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());

            return new ApiResponse<>(200, "Listagem de usuários realizada com sucesso!", usuarioDtos);
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Busca um usuário pelo ID.
     *
     * @param id ID do usuário a ser buscado.
     * @return ApiResponse com o resultado da busca.
     */
    public ApiResponse<UsuarioDto> findById(Long id) {
        try {
            // Busca o usuário pelo ID
            Optional<Usuario> resultado = usuarioRepository.findById(id);

            // Verifica se o usuário foi encontrado e retorna o ApiResponse correspondente
            return resultado.map(usuario -> new ApiResponse<>(200, "Detalhamento de usuário realizado com sucesso!",
                    new UsuarioDto(usuario))).orElseGet(() -> new ApiResponse<>(204, "Usuário não encontrado!", null));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Deleta um usuário pelo ID.
     *
     * @param id ID do usuário a ser deletado.
     * @return ApiResponse com o resultado da operação de exclusão.
     */
    public ApiResponse<UsuarioDto> deleteById(Long id) {
        try {
            // Verifica se o usuário existe pelo ID
            ApiResponse<UsuarioDto> existeUsuario = this.findById(id);

            // Se não encontrou o usuário, retorna ApiResponse indicando erro
            if (existeUsuario.getStatus() != 200) {
                return new ApiResponse<>(404, "Não foi possível excluir, pois usuário não foi encontrado por ID!", null);
            }

            // Deleta o usuário do banco de dados
            usuarioRepository.deleteById(id);

            return new ApiResponse<>(200, "Usuário excluído com sucesso!", existeUsuario.getData());
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }

    /**
     * Atualiza um usuário pelo ID.
     *
     * @param id  ID do usuário a ser atualizado.
     * @param dto DTO contendo os novos dados do usuário.
     * @return ApiResponse com o resultado da operação de atualização.
     */
    public ApiResponse<UsuarioDto> updateById(Long id, UsuarioDto dto) {
        try {
            // Verifica se o usuário existe pelo ID
            ApiResponse<UsuarioDto> existeUsuario = this.findById(id);

            // Se não encontrou o usuário, retorna ApiResponse indicando erro
            if (existeUsuario.getStatus() != 200) {
                return new ApiResponse<>(404, "Não é possível editar, pois usuário não foi encontrado por ID!", null);
            }

            // Converte DTO para entidade Usuario e define o ID
            Usuario usuario = UsuarioDto.convert(dto);
            usuario.setId(id);

            // Verifica se já existe outro usuário com o mesmo email
            if (usuarioRepository.existByEmailAndNotId(dto.getEmail(), id)) {
                return new ApiResponse<>(409, "Não é possível editar, pois já existe outro usuário com esse email!", null);
            }

            // Salva as alterações no banco de dados
            usuario = usuarioRepository.save(usuario);

            return new ApiResponse<>(200, "Usuário editado com sucesso!", new UsuarioDto(usuario));
        } catch (Exception e) {
            return new ApiResponse<>(500, e.getMessage(), null);
        }
    }
}
