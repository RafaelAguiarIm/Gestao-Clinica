package com.clinical.metamorfose.DTOs;

import com.clinical.metamorfose.models.Funcionario;
import com.clinical.metamorfose.models.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class FuncionarioDTO implements Serializable {
    private  static final long serialVersionUID = 1L;

    protected Long id;
    protected String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataNascimento;
    protected String cpf;
    protected String email;
    protected String senha;
    protected String telefone1;
    protected String telefone2;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    protected Set<Integer> perfis = new HashSet<>();

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet());
    }
    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }



//    protected Endereco endereco;


    public FuncionarioDTO() {
        super();
        addPerfil(Perfil.ADM);
    }

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.dataNascimento = funcionario.getDataNascimento();
        this.cpf = funcionario.getCpf();
        this.email = funcionario.getEmail();
        this.senha = funcionario.getSenha();
        this.telefone1 = funcionario.getTelefone1();
        this.telefone2 = funcionario.getTelefone2();
        this.perfis = funcionario.getPerfil().stream().map(perfil -> perfil.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = funcionario.getDataCriacao();
    }
}
