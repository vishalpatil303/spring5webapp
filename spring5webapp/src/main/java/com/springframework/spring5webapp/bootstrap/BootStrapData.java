package com.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springframework.spring5webapp.domin.Author;
import com.springframework.spring5webapp.domin.Book;
import com.springframework.spring5webapp.reository.AuthorRepository;
import com.springframework.spring5webapp.reository.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;

	}

	@Override
	public void run(String... args) throws Exception {

		Author a = new Author("Vishal", "Dwarkunde");
		Book b = new Book("Book of my Life", "1234");
		a.getBooks().add(b);
		b.getAuthors().add(a);

		authorRepository.save(a);
		bookRepository.save(b);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println("Started from Boot Strap");
		System.out.println("Number of Books" + bookRepository.count());
		System.out.println("Number of Authors " + authorRepository.count());

	}

}
