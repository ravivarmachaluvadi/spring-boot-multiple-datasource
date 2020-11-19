package com.example.springbootmultipledatasource;

import com.example.springbootmultipledatasource.author.repository.AuthorRepository;
import com.example.springbootmultipledatasource.book.repository.BookRepository;
import com.example.springbootmultipledatasource.model.author.Author;
import com.example.springbootmultipledatasource.model.book.Book;
import com.example.springbootmultipledatasource.model.user.User;
import com.example.springbootmultipledatasource.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootMultipleDatasourceApplication {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@PostConstruct
	public void addData2DB() {
		userRepository.saveAll(Stream.of(new User(744, "John"), new User(455, "Pitter")).collect(Collectors.toList()));
		bookRepository.saveAll(Stream.of(new Book(111, "Core Java"), new Book(222, "Spring Boot")).collect(Collectors.toList()));
		authorRepository.saveAll(Stream.of(new Author(100, "Rhonda"), new Author(200, "Hill")).collect(Collectors.toList()));

	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/getAuthors")
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDatasourceApplication.class, args);
	}

}
