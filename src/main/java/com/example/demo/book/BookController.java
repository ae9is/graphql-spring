package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

  @Autowired
  BookRepository repo;

  @QueryMapping
  public Book bookById(@Argument Long id) {
    try {
      return repo.getById(id);
    } catch (Exception e) {
      return null;
    }
  }
}
