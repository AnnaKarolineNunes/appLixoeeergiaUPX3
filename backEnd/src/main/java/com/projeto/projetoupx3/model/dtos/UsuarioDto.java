package com.projeto.projetoupx3.model.dtos;

import com.projeto.projetoupx3.model.Usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// DTO (Data Transfer Object) que representa um usuário para transferência de dados entre camadas
public class UsuarioDto {
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private String sobrenome;

    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    private String confirmaSenha;

    // Construtor que converte um objeto Usuario para UsuarioDto
    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.sobrenome = usuario.getSobrenome();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
    }

    // Método estático para converter UsuarioDto para Usuario
    public static Usuario convert(UsuarioDto usuarioDTO){
        Usuario usuario = new Usuario(usuarioDTO.getId());
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setSobrenome(usuarioDTO.getSobrenome());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setEmail(usuarioDTO.getEmail());
        return usuario;
    }

}
