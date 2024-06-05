package com.projeto.projetoupx3.repositories;

import com.projeto.projetoupx3.model.MaterialReciclavel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialReciclavelRepository extends JpaRepository<MaterialReciclavel, Long> {

    boolean existsByNome(String nome);
}
