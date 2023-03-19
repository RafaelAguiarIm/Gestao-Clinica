package com.clinical.metamorfose.resources;

import com.clinical.metamorfose.DTOs.FuncionarioDTO;
import com.clinical.metamorfose.models.Funcionario;
import com.clinical.metamorfose.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
        Funcionario funcionario = service.findById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(funcionario));
    }

    //localhost:8080/funcionarios/listAll
    @GetMapping(value = "/listAll")
    public ResponseEntity<List<FuncionarioDTO>> findAll(){
        List<Funcionario> listAllFuncionarios = service.findAll();
        List<FuncionarioDTO> lisAllFuncionarioDTO = listAllFuncionarios.stream().map(funcionario -> new FuncionarioDTO(funcionario)).collect(Collectors.toList());
        return ResponseEntity.ok().body(lisAllFuncionarioDTO);
    }

    //localhost:8080/funcionarios/create
//    @Transactional //Transação ativa com o BD
    @PostMapping//Anootation, post
    //Anotação @RequesteBody, indica que a String json irá receber os valores passasos na requisição
    public ResponseEntity create(@RequestBody @Valid FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriBuilder)
    {
        //recebe um DTO como paramentro do metodo e transformar em um Medico para então mandar para método Save()
        var funcionario = new Funcionario(funcionarioDTO);
        service.create(funcionarioDTO);

        //Cod 201 Created
        var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid FuncionarioDTO funcionarioDTO){
        var funcionario = new Funcionario(funcionarioDTO);
        service.update(id, funcionarioDTO);

        return ResponseEntity.ok().body(new FuncionarioDTO(funcionario));
    }
}
