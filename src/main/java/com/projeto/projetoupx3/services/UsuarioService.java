package com.projeto.projetoupx3.services;


import com.projeto.projetoupx3.model.Usuario;
import com.projeto.projetoupx3.model.dtos.UsuarioDTO;
import com.projeto.projetoupx3.repositories.UsuarioRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositoy usuarioRepositoy;

    public UsuarioDTO save(UsuarioDTO dto){
        Usuario usuario = UsuarioDTO.convert(dto);
        usuario = this.usuarioRepositoy.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public List<UsuarioDTO>findAll(){
        List<Usuario> usuarios = this.usuarioRepositoy.findAll();
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long idUsuario){
        Optional<Usuario> resultado = this.usuarioRepositoy.findById(idUsuario); // procurando o id no banco de dados
        if(resultado.isEmpty()){
            throw new RuntimeException("Usuario nao encontrado");
        }else {
            return new UsuarioDTO(resultado.get());
        }
    }

    public UsuarioDTO deleteById(Long idUsuario){
        UsuarioDTO dto = findById(idUsuario);
        this.usuarioRepositoy.deleteById(idUsuario);
        return dto;
    }

    public UsuarioDTO updateById(Long idUsuario, UsuarioDTO dto){
        this.findById(idUsuario);
        Usuario usuario = UsuarioDTO.convert(dto);
        usuario.setIdUsuario(idUsuario);
        usuario = this.usuarioRepositoy.save(usuario);
        return new UsuarioDTO((usuario));
    }

}
