package com.project.medfutura.dto;

import java.util.List;

import com.project.medfutura.entities.Pessoa;

public class PessoaDTO {
    
    private Long id;
    private String apelido;
    private String nome;
    private String nascimento;
    private List<String> stack;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa entity){
        id = entity.getId();
        apelido = entity.getApelido();
        nome = entity.getNome();
        nascimento = entity.getNascimento();
        stack = entity.getStack();
    }

    public Long getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }

    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public List<String> getStack() {
        return stack;
    }
}
