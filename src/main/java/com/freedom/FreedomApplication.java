package com.freedom;

import com.freedom.entity.Author;
import com.freedom.entity.Book;
import com.freedom.entity.PublisherHome;
import com.freedom.repository.AuthorRepository;
import com.freedom.repository.BookRepository;
import com.freedom.repository.PublisherHomeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class FreedomApplication implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherHomeRepository publisherHomeRepository;

	public FreedomApplication(AuthorRepository authorRepository,
							  BookRepository bookRepository,
							  PublisherHomeRepository publisherHomeRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherHomeRepository = publisherHomeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FreedomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Author author = new Author();
		author.setName("Mert");
		author.setDescription("Yazilimci");
		author.setDate(new Date());

		Author author1 = authorRepository.save(author);

		PublisherHome home = new PublisherHome();
		home.setDate(new Date());
		home.setName("DR");
		home.setDescription("DR KITAPADI");
		PublisherHome home1 = publisherHomeRepository.save(home);


		Book book = new Book();
		book.setAuthor(author1);
		book.setPublisherHome(home1);
		book.setName("YUZUKLERINN EFENDISI");

		bookRepository.save(book);



		// Serviceler
		// controller
		// Teplelate html dosyalarin.
		//






	}
}
