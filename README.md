# Blogging Platform API

A RESTful Blogging Platform API built with Java and Spring Boot.

This project is part of my journey of completing backend development projects from [roadmap.sh](https://roadmap.sh/projects/blogging-platform-api).

The goal is to build a REST API that allows users to create, retrieve, update, and delete blog posts.

## Features

- Create new blog posts.
- Retrieve all blog posts.
- Retrieve a single blog post by ID.
- Update existing blog posts.
- Delete blog posts.
- Store post categories and tags.
- Automatically track creation and update timestamps.
- Persist data using MySQL and Spring Data JPA.

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **ORM:** Hibernate / JPA
- **Dependency Management:** Maven
- **API Testing:** Postman

## Project Structure

```text
src/main/java/com/kryptic/bloggingplatform/
│
├── controllers/
│   └── PostsController.java
│
├── entity/
│   └── Posts.java
│
├── repository/
│   └── PostsRepository.java
│
├── services/
│
└── BloggingPlatformApplication.java
```

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/posts` | Create a new post |
| GET | `/api/posts` | Retrieve all posts |
| GET | `/api/posts/{id}` | Retrieve a post by ID |
| PUT | `/api/posts/{id}` | Update a post |
| DELETE | `/api/posts/{id}` | Delete a post |

## Example Request

### Create a Post

**POST** `/api/posts`

Request Body:

```json
{
  "title": "Learning Spring Boot",
  "content": "My first blogging API!",
  "category": "Programming",
  "tags": ["Java", "Spring Boot"]
}
```

## Database Setup

1. Install and start MySQL.
2. Create a database:

```sql
CREATE DATABASE blogging_platform;
```

3. Configure your database credentials in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogging_platform
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Project

Clone the repository:

```bash
git clone YOUR_REPOSITORY_URL
```

Navigate into the project:

```bash
cd blogging-platform
```

Run the application using Maven:

```bash
./mvnw spring-boot:run
```

The API will be available at:

`http://localhost:8080`

You can test the endpoints using Postman.

## Project Status

Currently implemented:

- [x] Project setup
- [x] MySQL database connection
- [x] Posts entity
- [x] JPA repository
- [x] Create post
- [x] Retrieve all posts
- [x] Retrieve post by ID
- [x] Update post
- [x] Delete post

More features and improvements will be added as the project develops.

---

**Part of my Spring Boot learning journey.**