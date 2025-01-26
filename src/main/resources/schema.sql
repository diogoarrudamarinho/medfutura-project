-- Criando a tabela tb_pessoa
CREATE TABLE IF NOT EXISTS tb_pessoa (
    id BIGSERIAL PRIMARY KEY,  
    apelido VARCHAR(32) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    nascimento VARCHAR(255) NOT NULL 
);

-- Criando a tabela pessoa_stack
CREATE TABLE IF NOT EXISTS pessoa_stack (
    pessoa_id BIGINT NOT NULL, 
    stack_item VARCHAR(32) NOT NULL,
    PRIMARY KEY (pessoa_id, stack_item),
    FOREIGN KEY (pessoa_id) REFERENCES tb_pessoa(id) 
);