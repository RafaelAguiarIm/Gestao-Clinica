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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncionarioResource {


    @Autowired
    private FuncionarioService service;

    //localhost:8080/funcionarios/1
    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id){
        Funcionario funcionario = service.findeById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(funcionario));
    }

    //localhost:8080/funcionarios/listAll
    @GetMapping(value = "/listAll")
    public ResponseEntity<List<FuncionarioDTO>> findAll(){
        List<Funcionario> listAllFuncionarios = service.findAll();
        List<FuncionarioDTO> lisAllFuncionarioDTO = listAllFuncionarios.stream().map(funcionario -> new FuncionarioDTO(funcionario)).collect(Collectors.toList());
        return ResponseEntity.ok().body(lisAllFuncionarioDTO);
    }
}
