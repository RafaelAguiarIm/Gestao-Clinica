package com.clinical.metamorfose.repositories;

import com.clinical.metamorfose.models.Funcionario;
import com.clinical.metamorfose.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Optional<Pessoa> findByCpf(String cpf);
    Optional<Pessoa> findByEmail(String email);
}
