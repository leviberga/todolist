# 📝 TodoList API

Sistema de gerenciamento de tarefas desenvolvido com **Java 21** e **Spring Boot 3**, como solução para o desafio de Desenvolvedor Júnior Backend da Simplify.

---

## 🚀 Tecnologias

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Flyway Migration
- Lombok
- Bean Validation
- Docker & Docker Compose

---

## ⚙️ Pré-requisitos

- [Java 21](https://adoptium.net/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## ▶️ Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/leviberga/todolist.git
cd todolist
```

### 2. Suba o banco de dados com Docker

```bash
docker-compose up -d
```

Isso irá criar e iniciar um container PostgreSQL com as seguintes configurações:

| Configuração | Valor              |
|--------------|--------------------|
| Host         | localhost          |
| Porta        | 5432               |
| Banco        | database_todolist  |
| Usuário      | user_dev           |
| Senha        | password_dev       |

### 3. Execute a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

> As migrations do Flyway serão executadas automaticamente ao iniciar a aplicação, criando a tabela de tarefas no banco de dados.

---

## 📦 Funcionalidades

A API oferece um CRUD completo de tarefas com os seguintes endpoints:

### Criar tarefa
**POST** `/tasks`

```json
{
  "name": "Minha tarefa",
  "description": "Descrição da tarefa",
  "isDone": false,
  "priority": "HIGH"
}
```

### Listar todas as tarefas
**GET** `/tasks`

### Buscar tarefa por ID
**GET** `/tasks/{id}`

### Atualizar tarefa
**PUT** `/tasks/{id}`

```json
{
  "name": "Tarefa atualizada",
  "description": "Nova descrição",
  "isDone": true,
  "priority": "LOW"
}
```

### Deletar tarefa
**DELETE** `/tasks/{id}`

---

## 📋 Campos da Tarefa

| Campo       | Tipo          | Obrigatório | Descrição                              |
|-------------|---------------|-------------|----------------------------------------|
| id          | UUID          | —           | Gerado automaticamente                 |
| name        | String        | ✅          | Nome da tarefa                         |
| description | String        | ✅          | Descrição detalhada                    |
| isDone      | Boolean       | ✅          | Status de conclusão (padrão: `false`)  |
| priority    | PriorityType  | ✅          | Prioridade: `LOW`, `MEDIUM` ou `HIGH`  |

---

## 🗂️ Estrutura do Projeto

```
src/main/java/com/leviberga/todolist/
├── controller/       # Endpoints REST
├── service/          # Regras de negócio
├── repository/       # Acesso ao banco de dados
├── model/            # Entidade JPA
├── dto/              # Objetos de transferência de dados
├── mapper/           # Conversão entre entidades e DTOs
├── enums/            # Enumerações (PriorityType)
└── exception/        # Tratamento global de exceções
```

---

## ⚠️ Tratamento de Erros

Quando uma tarefa não é encontrada, a API retorna:

```json
{
  "status": 404,
  "error": "Not Found",
  "message": "Task not found with the following ID: {id}",
  "timestamp": "2026-03-17T17:35:31"
}
```