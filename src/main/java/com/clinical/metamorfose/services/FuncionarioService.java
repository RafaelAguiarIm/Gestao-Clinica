package com.clinical.metamorfose.services;

import com.clinical.metamorfose.DTOs.FuncionarioDTO;
import com.clinical.metamorfose.models.Funcionario;
import com.clinical.metamorfose.models.Pessoa;
import com.clinical.metamorfose.repositories.FuncionarioRepository;
import com.clinical.metamorfose.repositories.PessoaRepository;
import com.clinical.metamorfose.services.exceptions.DataIntegrityViolationException;
import com.clinical.metamorfose.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Funcionario findById(Long id){
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado! Id: "+ id));
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario create(FuncionarioDTO funcionarioDTO){
        funcionarioDTO.setId(null);
        validaCpfAndEmail(funcionarioDTO);
        Funcionario funcionario = new Funcionario(funcionarioDTO);
        return funcionarioRepository.save(funcionario);
    }

    private void validaCpfAndEmail(FuncionarioDTO funcionarioDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(funcionarioDTO.getCpf());
        if (pessoa.isPresent() && pessoa.get().getId() != funcionarioDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado");
        }
        pessoa = pessoaRepository.findByEmail(funcionarioDTO.getEmail());
        if (pessoa.isPresent() && pessoa.get().getId() != funcionarioDTO.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado");
        }
    }

    public Funcionario update(Long id, FuncionarioDTO funcionarioDTO) {
        funcionarioDTO.setId(id);
        var funcionario = findById(id);
        validaCpfAndEmail(funcionarioDTO);
        funcionario = new Funcionario(funcionarioDTO);
        return  funcionarioRepository.save(funcionario);


    }


//    public void update(FuncionarioDTO funcionarioDTO) {
//        var funcionario = repository.getReferenceById(funcionarioDTO.getId());
//        funcionario.atualizarInformacoes(dadosMedico);
//
//    }
}
