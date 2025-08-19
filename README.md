# Spring Boot Taxes Demo WebFlux

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

- **Framework**: Spring Boot 3.5.4
- **Reactive Stack**: Spring WebFlux
- **Java Version**: 21
- **Databases**:
    - MongoDB (Reactive)
    - MySQL with R2DBC
- **Message Broker**: RabbitMQ
- **Build Tool**: Gradle
- **Testing**: JUnit 5, Reactor Test

## 📋 Prerequisites

- Java 21
- Docker and Docker Compose
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
docker-compose up -d
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

The application includes Docker Compose configuration for all dependencies. Use `docker-compose up -d` to start the
required services.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is for demonstration purposes.
