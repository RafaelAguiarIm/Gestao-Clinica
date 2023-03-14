package com.clinical.metamorfose.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Paciente extends Pessoa{
    private  static final long serialVersionUID = 1L;

    private String nomeResponsavel;
    private String parentesco;
}
