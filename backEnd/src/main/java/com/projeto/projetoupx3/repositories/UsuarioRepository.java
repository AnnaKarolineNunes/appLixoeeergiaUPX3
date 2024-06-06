package com.projeto.projetoupx3.repositories;

import com.projeto.projetoupx3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT COUNT(u) > 0 FROM Usuario u WHERE u.email = :email")
    boolean existByEmail(String email);

    @Query("SELECT COUNT(u) > 0 FROM Usuario u WHERE u.email = :email AND u.id <> :id")
    boolean existByEmailAndNotId(String email, Long id);

}