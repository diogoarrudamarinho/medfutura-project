# MedFutura API

API simples para gerenciamento de informações sobre pessoas criada para o processo seletivo da [MedFutura](https://www.medfutura.com.br/). A API permite a criação, consulta, atualização e exclusão de registros de pessoas, além de oferecer uma busca por termos no apelido, nome ou stack.

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 21** ou superior
- **Maven**
- **PostgreSQL** (ou outro banco de dados relacional, se preferir)

Para instalar o PostgreSQL, siga as instruções oficiais para o seu sistema operacional. No caso de estar utilizando PostgreSQL, crie um banco de dados e adicione as credenciais no arquivo `.env`.

## 🔧 Instalação

1. Clone o repositório:

    ```
    git clone <link-do-repositorio>
    ```

2. Acesse a pasta do projeto:

    ```
    cd <nome-do-repositorio>
    ```

3. Instale as dependências:

    ```
    mvn install
    ```

4. Configure o arquivo `.env` com as informações do banco de dados.

    ```env
    DB_URL=jdbc:postgresql://localhost:5432/medfutura_api
    DB_USERNAME=your_username
    DB_PASSWORD=your_password
    PORT=8080
    APP_PROFILE=dev
    ```
    
5. Rode a aplicação:

    ```
    mvn spring-boot:run
    ```

A API estará disponível em `http://localhost:8080`.

## Endpoints

* POST `(/pessoas)` - Cria uma nova pessoa.
* PUT `(/pessoas/:id)` - Atualiza uma pessoa existente.
* GET `(/pessoas/:id)` - Procura uma pessoa por `id`.
* GET `(/pessoas?t=)` - Procura uma pessoa por `termo`.
* DELETE `(/pessoas/id)` - Deleta uma pessoa por `id`.

###  Exemplo de Pessoa

```json
{
  "apelido": "josé",
  "nome": "José Roberto",
  "nascimento": "2000-10-01",
  "stack": ["C#", "Node", "Oracle"]
}
```

## 🛠️ Construído com

* [Java](https://www.oracle.com/java/) - Linguagem utilizada.
* [Spring Boot](https://spring.io/projects/spring-boot) - O framework usado.
* [Maven](https://maven.apache.org/) - Gerente de Dependência.
* [PostgreSQL](https://www.postgresql.org/) - Banco de dados utilizado.
