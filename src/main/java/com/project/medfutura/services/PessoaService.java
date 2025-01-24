package com.project.medfutura.services;

import java.util.List;

import com.project.medfutura.dto.PessoaDTO;
import com.project.medfutura.entities.Pessoa;

public interface PessoaService {
    
    void create(Pessoa entity);
    void delete(Long id);
    PessoaDTO findById(Long id);
    PessoaDTO update(Long id, Pessoa entity);
    List<PessoaDTO> searchByTerm(String term);
    
}
