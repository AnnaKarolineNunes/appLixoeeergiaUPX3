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
public class UsuarioDTO {
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O sobrenome é obrigatório")
    private String sobrenome;

    @NotBlank(message = "o email é obrigatório")
    private String email;

    @NotBlank(message = "a senha é obrigatória")
    private String senha;

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getIdUsuario();
        this.email = usuario.getEmail();
        this.sobrenome = usuario.getSobrenome();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
    }

    public static Usuario convert(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(usuarioDTO.getId());
        usuario.setIdUsuario(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setSobrenome(usuarioDTO.getSobrenome());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setEmail(usuarioDTO.getEmail());
        return usuario;
    }
}
