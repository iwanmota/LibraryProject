# Library Management System

A personal library management system built with Spring Boot and Java 17. This project demonstrates modern Java development practices, Spring Boot features, and progressive enhancement from a simple console application to a full-featured web application.

## 🚀 Features

- **Book Management**: Add, remove, and search books in your personal library
- **RESTful API**: Modern REST endpoints for book operations
- **Data Persistence**: JSON-based storage with plans for database integration
- **Modern Java**: Utilizes Java 17 features, Stream API, and functional programming
- **Spring Boot**: Built on Spring Boot 3.5.5 for rapid development
- **Lombok Integration**: Reduces boilerplate code with automatic generation

## 🛠️ Technology Stack

- **Java 17** - Latest LTS version with modern language features
- **Spring Boot 3.5.5** - Application framework and auto-configuration
- **Spring Web** - RESTful web services
- **Lombok** - Automatic code generation for POJOs
- **Maven** - Dependency management and build tool
- **JUnit 5** - Testing framework

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)
- IDE with Java support (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/iwanmota/LibraryProject.git
cd LibraryProject
```

### Build the Project

```bash
# Using Maven wrapper (recommended)
./mvnw clean compile

# Or using system Maven
mvn clean compile
```

### Run the Application

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using system Maven
mvn spring-boot:run

# Or run the JAR directly
./mvnw clean package
java -jar target/library-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

### Run Tests

```bash
./mvnw test
```

## 📁 Project Structure

```
LibraryProject/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── io/github/iwanmota/library/
│   │   │       └── LibraryApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── io/github/iwanmota/library/
│               └── LibraryApplicationTests.java
├── target/
├── pom.xml
├── PROJECT_PLAN.md
└── README.md
```

## 🎯 Development Roadmap

This project follows a phased development approach:

### ✅ Phase 1: Project Setup
- [x] Initialize Git repository
- [x] Set up Maven project structure
- [x] Configure Spring Boot
- [x] Add README documentation

### 🔄 Phase 2: Core Domain (In Progress)
- [ ] Implement Book entity with validation
- [ ] Create Library management service
- [ ] Add search and filtering capabilities
- [ ] Implement basic CRUD operations

### 📅 Upcoming Phases
- **Phase 3**: Data Persistence (JSON → Database)
- **Phase 4**: REST API Development
- **Phase 5**: Database Integration (H2 → JPA)
- **Phase 6**: Comprehensive Testing
- **Phase 7**: Security & Documentation

See [PROJECT_PLAN.md](PROJECT_PLAN.md) for detailed roadmap.

## 🔧 Configuration

### Application Properties

The application can be configured through `src/main/resources/application.properties`:

```properties
# Server configuration
server.port=8080

# Application configuration
spring.application.name=library
```

### Development Profiles

- **Default**: Basic configuration for development
- **Local**: Local development with enhanced logging
- **Production**: Optimized for production deployment

## 🧪 Testing

The project includes comprehensive testing:

```bash
# Run all tests
./mvnw test

# Run with coverage
./mvnw test jacoco:report

# Run integration tests
./mvnw verify
```

## 📚 API Documentation

Once the REST API is implemented, documentation will be available at:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- API Docs: `http://localhost:8080/v3/api-docs`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Iwan Mota** - [GitHub](https://github.com/iwanmota)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Project Lombok for reducing boilerplate code
- Java community for continuous innovation

---

⭐ Star this repository if you find it helpful!