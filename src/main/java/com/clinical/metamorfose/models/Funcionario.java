package com.clinical.metamorfose.models;

import com.clinical.metamorfose.DTOs.FuncionarioDTO;
import com.clinical.metamorfose.models.enums.Perfil;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Data
@Entity
//@Table
public class Funcionario extends Pessoa{
    private  static final long serialVersionUID = 1L;

    public Funcionario(Long id, String nome, String cpf, String email, String telefone1, String telefone2, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.senha = senha;
//        addPerfil(Perfil.ADM);
    }

    public Funcionario() {

    }

    public Funcionario(FuncionarioDTO funcionarioDTO) {
        this.id = funcionarioDTO.getId();
        this.nome = funcionarioDTO.getNome();
        this.dataNascimento = funcionarioDTO.getDataNascimento();
        this.cpf = funcionarioDTO.getCpf();
        this.email = funcionarioDTO.getEmail();
        this.senha = funcionarioDTO.getSenha();
        this.telefone1 = funcionarioDTO.getTelefone1();
        this.telefone2 = funcionarioDTO.getTelefone2();
        this.perfis = funcionarioDTO.getPerfis().stream().map(perfil -> perfil.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = funcionarioDTO.getDataCriacao();
    }


//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;



}
