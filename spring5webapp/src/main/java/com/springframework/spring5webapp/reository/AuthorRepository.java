package com.springframework.spring5webapp.reository;

import org.springframework.data.repository.CrudRepository;

import com.springframework.spring5webapp.domin.Author;



public interface AuthorRepository  extends CrudRepository<Author,Long>{

}
