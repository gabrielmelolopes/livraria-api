# Livraria API

API REST para gerenciamento de uma livraria, desenvolvida para fins de estudo e prática com Java e Spring Boot.

O sistema permite o cadastro de autores e livros, com relacionamento entre eles, validação de dados, regras de negócio e tratamento de erros padronizado.

---

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Docker / Docker Compose

---

## Como rodar localmente

### Pré-requisitos
- Java 17+
- Docker e Docker Compose
- Maven

### Passos

1. Clone o repositório
```bash
git clone https://github.com/gabrielmelolopes/livraria-api.git
cd livraria-api
```

2. Configure o arquivo de propriedades
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
Edite o `application.properties` com suas configurações de banco.

3. Suba o banco de dados com Docker
```bash
docker compose up -d
```

4. Rode a aplicação
```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## Endpoints

### Autores
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /autores | Cadastrar autor |
| GET | /autores/{id} | Buscar autor por ID |
| GET | /autores | Listar todos os autores |

### Livros
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /livros | Cadastrar livro |
| GET | /livros/{id} | Buscar livro por ID |
| GET | /livros | Listar todos os livros |
| GET | /livros/autor/{autorId} | Listar livros por autor |

---

## Regras de negócio

- Não é permitido cadastrar um livro com preço negativo

---

## Exemplos de uso

### Criar autor
```json
POST /autores
{
    "nome": "Machado de Assis",
    "nacionalidade": "Brasileiro"
}
```

### Criar livro
```json
POST /livros
{
    "titulo": "Dom Casmurro",
    "preco": 49.90,
    "ano_publicacao": 1899,
    "autor": {"id": 1}
}
```