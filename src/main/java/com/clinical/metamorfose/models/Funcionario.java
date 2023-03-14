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


//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;



}
