package com.start.egor;

//import com.start.egor.dbexample.dao.BookDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootApplication
public class AinurApplication implements CommandLineRunner {

//	private BookDAOBean bookDAOBean;

//	@Autowired
//	public void setBookDAOBean(BookDAOBean bookDAOBean) {
//		this.bookDAOBean = bookDAOBean;
//	}

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

//	public EgorApplication(BookDAOBean bookDAOBean){
//		this.bookDAOBean = bookDAOBean;
//	}

	public static void main(String[] args) {
		SpringApplication.run(AinurApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("test");


//		bookDAOBean.findBookById(3);
//		List<Book> bookList = jdbcTemplate.query("select * from books",
//				((rs, rowNum) -> new Book(
//						rs.getInt("id"),
//						rs.getString("title"),
//						rs.getString("author"),
//						rs.getDate("date_added")
//				)));
//		bookList.forEach(System.out::println);
	}
}
