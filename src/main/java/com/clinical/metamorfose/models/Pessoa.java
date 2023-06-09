package com.clinical.metamorfose.models;

import com.clinical.metamorfose.models.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
//@Table
//@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
//@DiscriminatorColumn( name="type" )
public abstract class Pessoa implements Serializable {
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataNascimento;
    @Column(unique = true)
    @NotBlank
//    @CPF //Verifica se é um cpf válido
    protected String cpf;
//    @Email
    @Column(unique = true)
    protected String email;

    protected String senha;
    protected String telefone1;
    protected String telefone2;
    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    protected Boolean disabled = false;

    public void desabilitar() {
        this.disabled = true;
    }

//    protected Endereco endereco;
    public Pessoa(){
        super();
        addPerfil(Perfil.ADM);
    }

    public Pessoa(Long id, String nome, LocalDate dataNascimento, String cpf, String email, String telefone1, String telefone2, String senha, Boolean disabled) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.senha = senha;
        this.disabled = disabled;
        addPerfil(Perfil.ADM);
    }

    public Set<Perfil> getPerfil() {
        return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet());
    }
    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }
}
