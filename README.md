# Movie Service

## Overview
The **Movie Service** is a microservice within the Movie Reservation System responsible for managing movie-related data. It handles movie creation, retrieval, and association with schedules and reservations.

## Features
- Add and manage movie records.
- Retrieve movie details by ID or category.
- Associate movies with schedules and reservations.

## Technologies Used
- **Spring Boot** – Core framework for building the microservice.
- **Spring Data JPA** – For interacting with the database.
- **MySQL** – Database for storing movie-related information.
- **Feign Client** – For inter-service communication.
- **Spring Cloud Eureka** – Service discovery and registration.

## API Endpoints

### Movie Management

#### Movie Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/movies` | Retrieve all movies |
| `GET` | `/movies/{id}` | Retrieve movie details by ID |
| `POST` | `/movies/multiple` | Retrieve multiple movies by IDs | 
| `POST` | `/movies/create` | Add a new movie |
| `PATCH` | `/movies/update/{id}` | Update movie by ID |

#### Genre Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/genres` | Retrieve all genres |
| `GET` | `/genres/{id}` | Retrieve genre by ID |
| `POST` | `/genres/create` | Create genre |
| `POST` | `/genres/multiple/create` | Create multiple genres at once |



## Service Communication
- Communicates with **Reservation Service** to manage movie reservations.

## Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/ChristosDurro/movie-reservation-system-movie-service.git
   ```
2. Navigate to the project folder:
   ```bash
   cd movie-reservation-system-movie-service
   ```
3. Configure the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/movie_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   # Eureka and other configurations you might want
   ```
4. Build and run the service:
   ```bash
   mvn spring-boot:run
   ```

---

This service is part of the **Movie Reservation System**, designed to showcase a microservices-based architecture with Spring Boot.

