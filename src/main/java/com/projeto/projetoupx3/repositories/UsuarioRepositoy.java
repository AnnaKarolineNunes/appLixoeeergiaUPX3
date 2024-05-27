package com.projeto.projetoupx3.repositories;

import com.projeto.projetoupx3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoy extends JpaRepository<Usuario, Long> {
}
