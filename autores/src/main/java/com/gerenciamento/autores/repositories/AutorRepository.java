package com.gerenciamento.autores.repositories;

import com.gerenciamento.autores.models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
}
