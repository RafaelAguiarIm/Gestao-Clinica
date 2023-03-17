package com.clinical.metamorfose.models;

import com.clinical.metamorfose.models.enums.Perfil;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Paciente extends Pessoa{
    private  static final long serialVersionUID = 1L;

    private String nomeResponsavel;
    private String parentesco;

    public Paciente(Long id, String nome, String cpf, String email, String telefone1, String telefone2, String nomeResponsavel, String parentesco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.nomeResponsavel = nomeResponsavel;
        this.parentesco = parentesco;
//        addPerfil(Perfil.ADM);
    }

    public Paciente() {

    }
}
