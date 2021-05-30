package com.example.springbootmultipledatasource;

import com.example.springbootmultipledatasource.author.repository.AuthorRepository;
import com.example.springbootmultipledatasource.book.repository.BookRepository;
import com.example.springbootmultipledatasource.book.repository.EmployeeRepository;
import com.example.springbootmultipledatasource.model.author.Author;
import com.example.springbootmultipledatasource.model.book.Book;
import com.example.springbootmultipledatasource.model.book.Employee;
import com.example.springbootmultipledatasource.model.user.User;
import com.example.springbootmultipledatasource.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class SpringBootMultipleDatasourceApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorRepository authorRepository;


	@Autowired
	private EmployeeRepository employeeRepository;

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

	@Override
	public void run(String... args) throws Exception {

		/*Employee employee = new Employee();

		employee.setEmployeeId(208);
		employee.setFIRST_NAME("Ravi");
		employee.setLAST_NAME("Chaluvadi");
		employee.setEMAIL("Varma");
		employee.setPHONE_NUMBER("778.020.8242");
		employee.setHIRE_DATE(new Date());
		employee.setJOB_ID("IT_PROG");
		employee.setSALARY(150000f);
		employee.setMANAGER_ID(208);
		employee.setDEPARTMENT_ID(60);

		employeeRepository.save(employee);
*/
		Employee employee1  =employeeRepository.findByEmployeeId(100);

		System.out.println(employee1);


	}
}
