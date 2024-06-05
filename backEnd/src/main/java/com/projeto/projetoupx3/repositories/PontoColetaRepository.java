package com.projeto.projetoupx3.repositories;

import com.projeto.projetoupx3.model.PontoColeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PontoColetaRepository extends JpaRepository<PontoColeta,Long> {
    boolean existsByNome(String nome);

}
