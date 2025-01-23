package com.project.medfutura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.medfutura.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
}
