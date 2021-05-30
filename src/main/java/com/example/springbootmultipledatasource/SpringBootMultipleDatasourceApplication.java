package com.example.springbootmultipledatasource;

import com.example.springbootmultipledatasource.author.repository.AuthorRepository;
import com.example.springbootmultipledatasource.book.repository.BookRepository;
import com.example.springbootmultipledatasource.book.repository.EmployeeRepository;
import com.example.springbootmultipledatasource.model.author.Author;
import com.example.springbootmultipledatasource.model.book.Book;
import com.example.springbootmultipledatasource.model.book.Employee;
import com.example.springbootmultipledatasource.model.user.User;
import com.example.springbootmultipledatasource.user.repository.UserRepository;
import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
	ApplicationContext applicationContext;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	@Qualifier(value = "bookEntityManagerFactory")
	SessionFactory sessionFactory;

	@Autowired
	Environment environment;

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
	@Transactional(rollbackFor =RuntimeException.class)
	public void run(String... args) throws Exception {

		/*Employee employee = new Employee();

		employee.setEmployeeId(700);
		employee.setFIRST_NAME("Nive");
		employee.setLAST_NAME("T");
		employee.setEMAIL("Nive");
		employee.setPHONE_NUMBER("778.020.8242");
		employee.setHIRE_DATE(new Date());
		employee.setJOB_ID("IT_PROG");
		employee.setSALARY(200000f);
		employee.setMANAGER_ID(205);
		employee.setDEPARTMENT_ID(60);

		employeeRepository.save(employee);*/
		getEmployee();
	}

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	private void getEmployee() {
		val v=environment.getProperty("hibernate.hbm2ddl.auto");
		Employee employee1  =employeeRepository.findByEmployeeId(100);
		System.out.println(employee1);

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);

		Root<Employee> root = criteria.from(Employee.class);

		criteria.where(
				builder.equal(root.get("employeeId"), 500)
		);

		List<Employee> employees = session
				.createQuery(criteria)
				.getResultList();

		for(Employee emp : employees){
			System.out.println(emp);
		}

		List<Employee> employeesListSQL = employeeRepository.findEmployees();

		//throw new RuntimeException("Explicit Exception");
	}
}
