package com.project.medfutura.services.Implementations;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.medfutura.dto.PessoaDTO;
import com.project.medfutura.entities.Pessoa;
import com.project.medfutura.repositories.PessoaRepository;
import com.project.medfutura.services.PessoaService;

@Service
public class PessoaServiceImp implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public void create(Pessoa entity) {
        if(entity.getId() != null && repository.existsById(entity.getId()))
            throw new IllegalArgumentException("Pessoa ID already exists");

        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Object ID is null");

        if(!repository.existsById(id))
            throw new ObjectNotFoundException("Object not found", id);

        repository.deleteById(id);
    }               

    @Override
    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id) {
        Pessoa pessoa = repository.findById(id)
                              .orElseThrow(() -> 
                              new ObjectNotFoundException("Object not Found", id));
   
        pessoa.getStack().size();
        return new PessoaDTO(pessoa);
    }

    @Override
    public PessoaDTO update(Long id, Pessoa entity) {
        Pessoa pessoa = repository.findById(id)
                        .orElseThrow(() -> 
                        new ObjectNotFoundException(
                        "Object not Found", id));

        pessoa.setApelido(entity.getApelido());
        pessoa.setNome(entity.getNome());
        pessoa.setNascimento(entity.getNascimento());
        pessoa.setStack(entity.getStack());
        repository.save(pessoa);

        return new PessoaDTO(pessoa);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PessoaDTO> searchByTerm(String term) {
        List<Pessoa> pessoas = repository.findAllByTerm(term.toLowerCase());
        pessoas.forEach(pessoa -> Hibernate.initialize(pessoa.getStack()));
        return pessoas.stream()
                      .map(PessoaDTO::new) // Converte Pessoa para PessoaDTO
                      .collect(Collectors.toList());
    }
    
}
