# Spring Boot Taxes Demo WebFlux

[![Java CI with Gradle](https://github.com/hendisantika/spring-boot-taxes-demo-webflux/actions/workflows/gradle.yml/badge.svg)](https://github.com/hendisantika/spring-boot-taxes-demo-webflux/actions/workflows/gradle.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-6DB33F?logo=springboot)
![Gradle](https://img.shields.io/badge/Gradle-9.8.2-02303A?logo=gradle)

A reactive Spring Boot application demonstrating tax processing with Clean Architecture principles, WebFlux, and
event-driven architecture using RabbitMQ.

## 🏗️ Architecture

This application follows **Clean Architecture** patterns with clear separation of concerns:

- **Domain Layer**: Core business logic and models
- **Use Cases**: Application-specific business rules
- **Infrastructure**: External integrations (REST clients, databases, message queues)
- **Presentation**: REST API endpoints and event handlers

## 🚀 Features

- **Reactive Programming**: Built with Spring WebFlux for non-blocking I/O
- **Multi-Database Support**: MongoDB (NoSQL) and MySQL (SQL) with R2DBC
- **Event-Driven Architecture**: RabbitMQ for message processing
- **Holiday Management**: Integration with external calendar API
- **Tax Processing**: Business logic for tax calculations and processing
- **Health Checks**: Spring Boot Actuator endpoints for monitoring

## 🛠️ Tech Stack

- **Framework**: Spring Boot 4.1.2
- **Reactive Stack**: Spring WebFlux, WebClient
- **Java Version**: 25
- **JSON**: Jackson 3 (`tools.jackson`)
- **Databases**:
    - MongoDB (Reactive)
    - MySQL with R2DBC
- **Message Broker**: RabbitMQ
- **Build Tool**: Gradle 9.8.2 (wrapper included)
- **Testing**: JUnit 5, Reactor Test, Testcontainers

## 📋 Prerequisites

- Java 25 (JDK 25, e.g. Eclipse Temurin)
- Docker and Docker Compose (Docker is also required to run the tests)
- Gradle (or use the included wrapper)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd spring-boot-taxes-demo-webflux
```

### 2. Start Infrastructure Services

The application uses Docker Compose to manage dependencies:

```bash
docker compose up -d
```

This will start:

- **MongoDB** on port 27017
- **MySQL** on port 3306
- **RabbitMQ** on ports 5672 (AMQP) and 15672 (Management UI)

### 3. Run the Application

```bash
./gradlew bootRun
```

The application will start on port 8080 with base path `/api/v1/tax`.

> 💡 Thanks to Spring Boot's Docker Compose support, `./gradlew bootRun` also starts (and stops) the services in
> `compose.yaml` automatically, so step 2 is optional during development.

## 🔧 Configuration

### Environment Variables

| Variable            | Default    | Description           |
|---------------------|------------|-----------------------|
| `APP_PORT`          | 8080       | Application port      |
| `ENV`               | local      | Active profile        |
| `MYSQL_HOST`        | localhost  | MySQL host            |
| `MYSQL_PORT`        | 3306       | MySQL port            |
| `MYSQL_USER`        | yu71       | MySQL username        |
| `MYSQL_PASSWORD`    | 53cret     | MySQL password        |
| `MYSQL_DATABASE`    | taxes_db   | MySQL database name   |
| `MONGO_HOST`        | localhost  | MongoDB host          |
| `MONGO_PORT`        | 27017      | MongoDB port          |
| `MONGO_USER`        | admin      | MongoDB username      |
| `MONGO_PASSWORD`    | password   | MongoDB password      |
| `MONGO_DATABASE`    | taxes_Demo | MongoDB database name |
| `RABBITMQ_HOST`     | localhost  | RabbitMQ host         |
| `RABBITMQ_PORT`     | 5672       | RabbitMQ port         |
| `RABBITMQ_USERNAME` | admin      | RabbitMQ username     |
| `RABBITMQ_PASSWORD` | password   | RabbitMQ password     |

## 📖 API Endpoints

### Health Checks

- `GET /health` - Application health status
- `GET /liveness` - Liveness probe
- `GET /readiness` - Readiness probe

### Holiday Management

- Base path: `/api/v1/tax/holidays`

### Message Processing

- Base path: `/api/v1/tax/messages`

## 🐰 RabbitMQ Integration

The application uses RabbitMQ for event-driven messaging:

- **Queue**: `tax_demo_test`
- **Events**:
    - `TAX_EVENT_MESSAGE`
    - `TAX_EVENT_OTHER`
- **Management UI**: http://localhost:15672 (admin/password)

## 🗄️ Database Schema

### MongoDB Collections

- `messages` - Stores message processing data

### MySQL Tables

- `holidays` - Holiday information for tax calculations

## 🔍 Monitoring

The application includes comprehensive monitoring:

- **Actuator Endpoints**: Health, metrics, liveness, and readiness probes
- **Logging**: Configurable log levels for different components
- **Connection Pooling**: Optimized database connection management

## 🧪 Testing

Run tests with:

```bash
./gradlew test
```

The context test uses [Testcontainers](https://testcontainers.com/) to start MySQL, MongoDB and RabbitMQ
automatically, so only a running Docker daemon is required — no need to run `docker compose` first.

## 🏃‍♂️ Running in Development

For development with hot reload:

```bash
./gradlew bootRun --continuous
```

## 📦 Building for Production

```bash
./gradlew build
```

This creates a JAR file in `build/libs/` directory.

## 🐳 Docker Support

The application includes Docker Compose configuration for all dependencies. Use `docker compose up -d` to start the
required services.

## 🔄 CI/CD & Dependency Updates

- **GitHub Actions** (`.github/workflows/gradle.yml`): builds and tests the project on JDK 25 (Temurin) for every
  push and pull request to `main`, and submits the dependency graph for Dependabot alerts.
- **Dependabot** (`.github/dependabot.yml`):
    - **Gradle** — checked daily; related updates are grouped (Spring Boot, Kotlin, reactive-commons, R2DBC,
      Testcontainers, and remaining minor/patch bumps)
    - **GitHub Actions** — checked weekly and grouped into a single PR
    - **Docker Compose** — container images in `compose.yaml` checked weekly
    - PRs use conventional commit prefixes (`build(deps)`, `ci(deps)`, `build(docker)`)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is for demonstration purposes.
