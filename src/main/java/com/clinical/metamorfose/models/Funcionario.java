package com.clinical.metamorfose.models;

import com.clinical.metamorfose.models.enums.Perfil;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
//@Table
public class Funcionario extends Pessoa{
    private  static final long serialVersionUID = 1L;

    private String nomeResponsavel;
    private String parentesco;

    public Funcionario(Integer id, String nome, String cpf, String email, String telefone1, String telefone2, String senha) {
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


//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;



}
