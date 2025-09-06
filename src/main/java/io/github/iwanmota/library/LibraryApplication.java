package io.github.iwanmota.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {
//    @Component
//    public class LibraryInitializer {
//        public LibraryInitializer(LibraryService libraryService) {
//            initializeBooks().forEach(libraryService::addBook);
//        }
//    }

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

//    public List<Book> initializeBooks(){
//        return new ArrayList<>(
//            Arrays.asList(
//                new Book("The Great Gatsby", "F. Scott Fitzgerald", "A novel about the American dream", "978-3-16-148410-0", 180, 1925),
//                new Book("To Kill a Mockingbird", "Harper Lee", "A novel about racial injustice", "978-0-06-112008-4", 281, 1960),
//                new Book("1984", "George Orwell", "A dystopian novel about totalitarianism", "978-0-452-28423-4", 328, 1949),
//                new Book("Pride and Prejudice", "Jane Austen", "A romantic novel about manners and morality", "978-0-19-953764-7", 279, 1813),
//                new Book("The Catcher in the Rye", "J.D. Salinger", "A novel about teenage angst and alienation", "978-0-316-76948-0", 223, 1951)
//            )
//        );
//    }
}

