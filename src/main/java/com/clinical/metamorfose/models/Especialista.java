package com.clinical.metamorfose.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Especialista extends Pessoa{
    private  static final long serialVersionUID = 1L;

    private String escpecialidade;
    private String conselho;
    private  Double valor;
}
