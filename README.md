# Todo App (Spring Boot + PostgreSQL)

A simple **Todo application** built with **Java Spring Boot** and **PostgreSQL**, following a clean layered architecture with support for **partial updates (PATCH)** using a Mapper.

## Features

- Create, read, update, and delete todos (CRUD)
- Partial updates via `PATCH` (update only selected fields)
- Enum support for **priority** (LOW, MEDIUM, HIGH)
- RESTful API with JSON responses
- PostgreSQL as the database
- Clean architecture (Controller → Service → Repository → Model/DTO)

## Tech Stack

- **Java 17+**
- **Spring Boot 3**
  - Spring Web
  - Spring Data JPA
- **PostgreSQL**
- **Maven**
- **MapStruct** (for PATCH mapping)

## Project Structure

```
src/main/java/com/example/todo
 ├── controller/        # REST Controllers (API endpoints)
 ├── dto/               # DTOs for requests/responses
 ├── mapper/            # Mapper for partial updates
 ├── model/             # JPA Entities
 ├── repository/        # Spring Data Repositories
 └── service/           # Business logic
```

## Setup & Installation

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/todo-app.git
cd todo-app
```

### 2. Configure PostgreSQL

Make sure PostgreSQL is installed and running. Create a database (e.g., `todo_db`):

```sql
CREATE DATABASE todo_db;
```

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

The app will run on: `http://localhost:8080`

## API Endpoints

### Todos

**Get all todos**
```
GET /todos
```

**Get todo by ID**
```
GET /todos/{id}
```

**Create todo**
```
POST /todos
Content-Type: application/json

{
  "title": "Learn Spring Boot",
  "priority": "HIGH",
  "completed": false
}
```

**Update todo completely**
```
PUT /todos/{id}
Content-Type: application/json

{
  "title": "Learn JPA",
  "priority": "MEDIUM",
  "completed": true
}
```

**Partial update (PATCH)**
```
PATCH /todos/{id}
Content-Type: application/json

{
  "priority": "LOW",
  "completed": true
}
```

**Delete todo**
```
DELETE /todos/{id}
```

## Example Todo Entity

```java
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String title;
    
    private Boolean completed;
    
    @Enumerated(EnumType.STRING)
    private Priority priority;
    
    // Getters, setters, and constructors...
}
```

## Testing the API

You can test the API using tools like:
- **Postman**
- **curl**
- **Thunder Client** (VS Code extension)
- **IntelliJ HTTP Client**

Example curl commands:

```bash
# Create a new todo
curl -X POST http://localhost:8080/todos \
  -H "Content-Type: application/json" \
  -d '{"title": "Learn Spring Boot", "priority": "HIGH", "completed": false}'

# Get all todos
curl http://localhost:8080/todos

# Update priority only (PATCH)
curl -X PATCH http://localhost:8080/todos/1 \
  -H "Content-Type: application/json" \
  -d '{"priority": "LOW"}'
```

## Future Enhancements

- [ ] Add user authentication (JWT)
- [ ] Implement due dates for todos
- [ ] Add categories/tags
- [ ] Create a React/Angular frontend
- [ ] Add pagination for large datasets
- [ ] Implement search functionality