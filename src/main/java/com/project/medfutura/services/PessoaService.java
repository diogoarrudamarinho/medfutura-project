package com.project.medfutura.services;

import com.project.medfutura.dto.PessoaDTO;
import com.project.medfutura.entities.Pessoa;

public interface PessoaService {
    
    void create(Pessoa entity);
    void delete(Long id);
    PessoaDTO findById(Long id);
    PessoaDTO update(Long id, Pessoa entity);
    PessoaDTO searchByTerm(String term);
    
}
