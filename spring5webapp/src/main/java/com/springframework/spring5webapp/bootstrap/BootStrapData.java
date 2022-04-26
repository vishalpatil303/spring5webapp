package com.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springframework.spring5webapp.domin.Author;
import com.springframework.spring5webapp.domin.Book;
import com.springframework.spring5webapp.domin.Publisher;
import com.springframework.spring5webapp.reository.AuthorRepository;
import com.springframework.spring5webapp.reository.BookRepository;
import com.springframework.spring5webapp.reository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();

		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Publisher p = new Publisher("Patil", "N 9", "Aurangabad", "Mahashatra", 431001);
		publisherRepository.save(p);
		Author a = new Author("Vishal", "Dwarkunde");
		authorRepository.save(a);
		Book b = new Book("Book of my Life", "1234");
		bookRepository.save(b);

		a.getBooks().add(b);
		b.getAuthors().add(a);
		b.setPublisher(p);
		bookRepository.save(b);
		authorRepository.save(a);
		p.getBooks().add(b);

		publisherRepository.save(p);

		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(p.toString());

		System.out.println("Started from Boot Strap");
		System.out.println("Number of Books" + bookRepository.count());
		System.out.println("Number of Authors " + authorRepository.count());
		System.out.println("Number of Publisher " + publisherRepository.count());

	}

}
