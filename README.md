# 🎬 Movie API Demo

Este projeto é uma API REST que gerencia um catálogo de filmes.  
O arquivo `Movielist.csv` está localizado na pasta `target/classes` e é carregado ao iniciar a aplicação.

---

## 🚀 Como utilizar

Após executar o projeto (`localhost:8080`), você poderá fazer requisições HTTP para os seguintes endpoints:

### 📄 Obter todos os filmes
**GET** 
```
http://localhost:8080/movies
```

### ➕ Criar um novo filme
**POST**  
```
POST http://localhost:8080/movies
```

**Corpo da requisição:**

```json
{
  "id": "52ce521a-96dd-499c-9f98-32092297287b",
  "title": "Titanic",
  "year": "1980",
  "studios": "Associated Film Distribution",
  "producers": "Allan Carr",
  "winner": "yes"
}
```
### 🔍 Buscar filme por ID
**GET by id**
```
http://localhost:8080/movies/52ce521a-96dd-499c-9f98-32092297287b
```

### 📝 Atualizar um filme
**PUT**

```
http://localhost:8080/movies/52ce521a-96dd-499c-9f98-32092297287b
```
**Corpo da requisição:**
```json
{
  "title": "Titanic",
  "year": "1998",
  "studios": "Fox Baja Studios",
  "producers": "James Cameron",
  "winner": "yes"
}
```

## ❌ Deletar um filme
**DELETE**
```
http://localhost:8080/movies/52ce521a-96dd-499c-9f98-32092297287b
```

## 🏆 Listar apenas vencedores
**GET**
```
http://localhost:8080/movies/winners
```

## 🛠 Tecnologias utilizadas
- Java 21
- Spring Boot
- H2 Database
- Maven

## 👤 Autor
**Bruno Roberto Pereira de Souza**
**📧 bruno_suza@hotmail.com**
