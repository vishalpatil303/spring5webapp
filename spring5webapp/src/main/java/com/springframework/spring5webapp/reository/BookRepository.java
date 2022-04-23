package com.springframework.spring5webapp.reository;
import org.springframework.data.repository.CrudRepository;

import com.springframework.spring5webapp.domin.Book;


public interface BookRepository extends CrudRepository <Book, Long>{

}
