package com.project.medfutura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.medfutura.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    @Query( "SELECT DISTINCT p FROM Pessoa p LEFT JOIN p.stack stackItem " +
            "WHERE LOWER(p.apelido) LIKE %:term% " +
            "OR LOWER(p.nome) LIKE %:term% " +
            "OR LOWER(stackItem) LIKE %:term%")
    List<Pessoa> findAllByTerm(@Param("term") String term);

}
