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

    //Método para inativa - Neste modelo apenas inativa o medico
    @DeleteMapping("/{id}")
//    @Transactional
    //A annotation @PathVariable vincula o Id  passado no @DeleteMapping com o id criado no método delete(Long id)
    public ResponseEntity inativa(@PathVariable Long id){
        service.getReferenceById(id);
              //Cod 204 No Content
        return ResponseEntity.noContent().build();
    }

    //Método para delete

//    @DeleteMapping("/{id}")
//    @Transactional
//    //A annotation @PathVariable vincula o Id  passado no @DeleteMapping com o id criado no método delete(Long id)
//    public void delete(@PathVariable Long id){
//        repository.deleteById(id);
//    }

    // Variacoes para o metodo FIND

    /*

     //Método com Paginação - Substitui o o List por Page e acrescenta os paramentros no listAll(Pageable paginacao) e no método findAll(paginacao)
     @GetMapping("/true") //Anotation Get
     public ResponseEntity<Page<ListMedicoDTO>> listByStatusTrue(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){ //Método para listar todos os médicos
     var page =  repository.findAllByStatusTrue(paginacao).map(ListMedicoDTO::new);
     //Cod 200 ok
     return ResponseEntity.ok(page);
     }

     //Método com Paginação - Substitui o o List por Page e acrescenta os paramentros no listAll(Pageable paginacao) e no método findAll(paginacao)
     @GetMapping("/false") //Anotation Get
     public ResponseEntity<Page<ListMedicoDTO>> listByStatusFalse(@PageableDefault(size=5, sort = {"nome"}) Pageable paginacao){ //Método para listar todos os médicos
     var page =  repository.findAllByStatusFalse(paginacao).map(ListMedicoDTO::new);
     //Cod 200 ok
     return ResponseEntity.ok(page);
     }

     @GetMapping("/listAll") //Anotation Get
     public ResponseEntity<Page<ListMedicoDTO>> findAll(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){ //Método para listar todos os médicos
     var page =  repository.findAll(paginacao).map(ListMedicoDTO::new);
     //Cod 200 ok
     return ResponseEntity.ok(page);
     }

     */
}
