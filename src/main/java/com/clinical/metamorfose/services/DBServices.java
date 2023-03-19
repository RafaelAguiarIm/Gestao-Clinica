package com.clinical.metamorfose.services;

import com.clinical.metamorfose.models.Especialista;
import com.clinical.metamorfose.models.Funcionario;
import com.clinical.metamorfose.models.Paciente;
import com.clinical.metamorfose.models.enums.Perfil;
import com.clinical.metamorfose.repositories.EspecialistaRepository;
import com.clinical.metamorfose.repositories.FuncionarioRepository;
import com.clinical.metamorfose.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;


@Service
public class DBServices {

    public DBServices(){
    }

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private EspecialistaRepository especialistaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void instanciaDB(){

        Funcionario f1 = new Funcionario(null, "Rafael","55544433321", "rafael@gmail.com", "88998051931", null, "123", false);
        f1.addPerfil(Perfil.ADM);

        Funcionario f2 = new Funcionario(null, "Adriana","99988877766", "adriana@gmail.com", "88997477299", null, "123",false);
        f2.addPerfil(Perfil.ADM);

        Funcionario f3 = new Funcionario(null, "Ravelly","00011122200", "ravelly@gmail.com", "88999289747", null, "123",false);
        f3.addPerfil(Perfil.RECEPCIONISTA);

        Funcionario f4 = new Funcionario(null, "Evilania","12345678900", "evilania@gmail.com", "88999289747", null, "123", false);
        f4.addPerfil(Perfil.RECEPCIONISTA);

        Especialista e1 = new Especialista(null, "Liana","11122233300", "liana@gmail.com", "88998051931", null, "123", "Pediatra", "CRM 100", 250.00 );
        e1.addPerfil(Perfil.ESPECIALISTA);

        Paciente p1 = new Paciente(null, "Paciente 1","12312312312", null,"88998051931", null, null, null);
        p1.addPerfil(Perfil.PACIENTE);

        funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4));
        especialistaRepository.saveAll(Arrays.asList(e1));
        pacienteRepository.saveAll(Arrays.asList(p1));
    }
}
