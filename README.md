# Library Management System

A personal library management system built with Spring Boot and Java 21. This project demonstrates modern Java development practices, Spring Boot features, and progressive enhancement from a simple console application to a full-featured web application.

## 🚀 Features

- **Book Management**: Add, remove, and search books in your personal library
- **RESTful API**: Modern REST endpoints for book operations
- **Data Persistence**: JSON-based storage with plans for database integration
- **Modern Java**: Utilizes Java 21 features, Stream API, and functional programming
- **Spring Boot**: Built on Spring Boot 3.5.5 for rapid development
- **Lombok Integration**: Reduces boilerplate code with automatic generation

## 🛠️ Technology Stack

- **Java 21** - Latest LTS version with modern language features
- **Spring Boot 3.5.5** - Application framework and auto-configuration
- **Spring Web** - RESTful web services
- **Lombok** - Automatic code generation for POJOs
- **Maven** - Dependency management and build tool
- **JUnit 5** - Testing framework

## 📋 Prerequisites

- Java 21 or higher
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
│   │   │       ├── model/
│   │   │       │   └── Book.java
│   │   │       ├── service/
│   │   │       ├── controller/
│   │   │       └── LibraryApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── io/github/iwanmota/library/
│               ├── model/
│               │   └── BookTest.java
│               └── LibraryApplicationTests.java
├── target/
├── pom.xml
├── PROJECT_PLAN.md
└── README.md
```

## 🎯 Development Roadmap

This project follows an **incremental learning approach** designed to gradually introduce Spring Boot concepts:

### ✅ Week 1-2: Basic Structure (Plain Java)
- [x] Initialize Git repository
- [x] Set up Maven project structure
- [x] Configure Spring Boot
- [x] Create Book model with unit tests
- [ ] Implement LibraryService with in-memory storage

### 🔄 Week 3-4: Spring Boot Basics (Current)
- [ ] Add @Component annotations
- [ ] Create basic REST controller
- [ ] Learn dependency injection
- [ ] Test with Postman/curl

### 📅 Upcoming Weeks
- **Week 5-6**: File-based JSON persistence
- **Week 7-8**: Validation & error handling
- **Week 9-10**: Database integration (H2 → JPA)
- **Week 11-12**: Advanced features & search
- **Week 13-14**: Testing & documentation

See [PROJECT_PLAN.md](PROJECT_PLAN.md) for detailed weekly roadmap.

## 🎓 Learning Philosophy

This project is designed for **incremental learning**:

1. **Start Simple**: Begin with plain Java classes
2. **Add Spring Gradually**: Introduce annotations one at a time
3. **Understand Each Step**: Learn what each feature does before moving on
4. **Keep It Working**: Maintain functional code throughout
5. **Test Early**: Write tests for each new feature

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

## 👨💻 Author

**Iwan Mota** - [GitHub](https://github.com/iwanmota)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Project Lombok for reducing boilerplate code
- Java community for continuous innovation

---

⭐ Star this repository if you find it helpful!