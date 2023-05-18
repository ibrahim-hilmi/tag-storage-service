# Tags Service

A Spring Boot REST API for tag management and analytics. Tracks and analyzes user tag interactions to provide tag counts and percentage statistics.

## Features

- Tag creation and persistence
- Tag counting by user and key
- Tag percentage calculations
- User interaction analytics

## Tech Stack

- Java 17
- Spring Boot 3.0.5
- MySQL Database
- Spring Data JPA
- MapStruct
- Lombok

## Requirements

- Java 17+
- Maven
- MySQL 8.0+

## Setup

1. Configure database in `src/main/resources/application.yml`

2. Build the project:

   ```bash
   ./mvnw clean install
   ```

3. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8086`

## API Endpoints

- `POST /tag` - Create a single tag
- `POST /tag/multi` - Create multiple tags
- `GET /tag/count/{uid}/{key}/{limit}` - Get tag counts by user and key
- `GET /tag/showed/{uid}/{key}/{limit}` - Get showed tag counts by user and key
- `GET /tag/percent/{uid}/{key}/{limit}` - Get tag percentages by user and key
