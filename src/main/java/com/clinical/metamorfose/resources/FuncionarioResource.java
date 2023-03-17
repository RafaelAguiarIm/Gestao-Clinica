package com.clinical.metamorfose.resources;

import com.clinical.metamorfose.DTOs.FuncionarioDTO;
import com.clinical.metamorfose.models.Funcionario;
import com.clinical.metamorfose.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncionarioResource {
    //localhost:8080/funcionarios/1

    @Autowired
    private FuncionarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id){
        Funcionario funcionario = service.findeById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(funcionario));
    }
}
