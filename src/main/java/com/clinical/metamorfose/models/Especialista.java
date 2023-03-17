package com.clinical.metamorfose.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Especialista extends Pessoa{
    private  static final long serialVersionUID = 1L;

    private String escpecialidade;
    private String conselho;
    private  Double valor;

    public Especialista(Long id, String nome,  String cpf, String email, String telefone1, String telefone2, String senha, String escpecialidade, String conselho, Double valor) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.senha = senha;
        this.escpecialidade = escpecialidade;
        this.conselho = conselho;
        this.valor = valor;
    }

    public Especialista() {

    }
}
