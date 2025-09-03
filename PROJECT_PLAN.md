# Library Management System - Development Plan

## Incremental Learning Approach

This project follows a gradual, week-by-week learning path to master Spring Boot while building a functional library management system.

---

## Week 1-2: Basic Structure (Plain Java)

### ✅ Project Setup
- [x] Initialize Git repository
- [x] Set up Maven project structure
- [x] Configure Spring Boot
- [x] Add README documentation

### 🔄 Core Domain Models (In Progress)
- [x] Create Book class with basic attributes (title, author, isbn, description, pages, year)
- [x] Implement toString(), equals(), and hashCode()
- [x] Add unit tests for Book class
- [x] Create LibraryService with in-memory List
- [x] Implement basic operations (add/remove/find books)
- [ ] Add search functionality using Stream API

**Key Focus**: Plain Java implementation without Spring annotations

```java
// service/LibraryService.java
public class LibraryService {
    private List<Book> books = new ArrayList<>();
    
    public void addBook(Book book) { /* implementation */ }
    public List<Book> getAllBooks() { /* implementation */ }
    public Optional<Book> findByIsbn(String isbn) { /* implementation */ }
}
```

---

## Week 3-4: Spring Boot Basics

### 🔄 Spring Boot Integration
- [ ] Add @Component to LibraryService
- [ ] Learn dependency injection basics
- [ ] Create simple REST controller
- [ ] Test with Postman/curl
- [ ] Understand Spring Boot auto-configuration

**Key Focus**: Adding Spring annotations gradually

```java
@Component
public class LibraryService { /* same code as before */ }

@RestController
@RequestMapping("/api/books")
public class BookController { /* basic CRUD endpoints */ }
```

---

## Week 5-6: Data Persistence

### 📁 File-Based Storage
- [ ] Add Jackson dependency for JSON processing
- [ ] Implement file-based storage (books.json)
- [ ] Add save/load functionality to LibraryService
- [ ] Basic error handling for file operations
- [ ] Learn about ObjectMapper

**Key Focus**: Simple persistence without database complexity

```java
@Component
public class LibraryService {
    private static final String FILE_PATH = "books.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    public void saveToFile() { /* implementation */ }
    public void loadFromFile() { /* implementation */ }
}
```

---

## Week 7-8: Validation & Error Handling

### ✅ Input Validation
- [ ] Add validation annotations to Book class
- [ ] Create custom exceptions (BookNotFoundException, etc.)
- [ ] Implement global exception handler
- [ ] Add proper HTTP status codes
- [ ] Learn about @Valid and validation groups

**Key Focus**: Robust error handling and data validation

```java
public class Book {
    @NotBlank(message = "Title is required")
    private String title;
    
    @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$", 
            message = "Invalid ISBN format")
    private String isbn;
}

@ControllerAdvice
public class GlobalExceptionHandler { /* exception handling */ }
```

---

## Week 9-10: Database Integration

### 🗄️ H2 Database & JPA
- [ ] Add H2 database dependency
- [ ] Configure database properties
- [ ] Convert Book to JPA entity
- [ ] Create BookRepository interface
- [ ] Implement repository pattern
- [ ] Add transaction management

**Key Focus**: Transition from file storage to database

```java
@Entity
public class Book { /* JPA annotations */ }

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}
```

---

## Week 11-12: Advanced Features

### 🔍 Enhanced Functionality
- [ ] Add advanced search capabilities
- [ ] Implement pagination and sorting
- [ ] Add book categories/genres
- [ ] Create book lending system
- [ ] Add user management basics

---

## Week 13-14: Testing & Documentation

### 🧪 Comprehensive Testing
- [ ] Unit tests for all services
- [ ] Integration tests for REST endpoints
- [ ] Test database operations
- [ ] Add test coverage reporting
- [ ] Mock external dependencies

### 📚 Documentation
- [ ] Add Swagger/OpenAPI documentation
- [ ] Create API documentation
- [ ] Update README with complete setup guide
- [ ] Add code documentation

---

## Optional Enhancements (Future)

### 🔒 Security
- [ ] Add Spring Security
- [ ] Implement basic authentication
- [ ] Add user roles and permissions

### 🚀 DevOps
- [ ] Add Docker support
- [ ] Create CI/CD pipeline
- [ ] Add logging configuration
- [ ] Implement monitoring

---

## Learning Resources

### Essential Spring Boot Concepts
```java
// Dependency Injection
@Autowired, @Component, @Service

// Web Layer
@RestController, @RequestMapping, @GetMapping, @PostMapping

// Data Layer
@Entity, @Repository, @Transactional

// Validation
@Valid, @NotNull, @Size
```

### Recommended Documentation
- Spring Boot Reference Documentation
- Baeldung Spring Boot tutorials
- Spring Guides (spring.io/guides)

---

## Success Metrics

- **Week 2**: Working Book model with unit tests
- **Week 4**: Basic REST API responding to requests
- **Week 6**: Data persisting to JSON file
- **Week 8**: Proper error handling and validation
- **Week 10**: Full database integration
- **Week 12**: Production-ready application

---

## Key Principles

1. **Start Simple**: Begin with plain Java, add Spring gradually
2. **Test Early**: Write tests for each new feature
3. **Incremental Progress**: Each week builds on the previous
4. **Focus on Understanding**: Learn what each annotation does
5. **Keep It Working**: Maintain functional code throughout

This approach ensures steady progress while building deep understanding of Spring Boot concepts.