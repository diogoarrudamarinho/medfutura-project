package com.project.medfutura.services.Implementations;
import org.hibernate.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PessoaDTO findById(Long id) {
        return new PessoaDTO(repository.findById(id)
                            .orElseThrow(() -> 
                            new ObjectNotFoundException(
                            "Object not Found", id)));
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
    public PessoaDTO searchByTerm(String term) {
        // TODO: Implement searchByTerm
        return new PessoaDTO();
    }
    
}
