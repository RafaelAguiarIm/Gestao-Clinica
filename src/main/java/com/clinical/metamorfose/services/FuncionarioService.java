package com.clinical.metamorfose.services;

import com.clinical.metamorfose.models.Funcionario;
import com.clinical.metamorfose.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario findeById(Long id){
        Optional<Funcionario> obj = repository.findById(id);
        return obj.orElse(null);
    }



}
