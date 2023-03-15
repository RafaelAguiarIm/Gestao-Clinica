package com.clinical.metamorfose.repositories;

import com.clinical.metamorfose.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
