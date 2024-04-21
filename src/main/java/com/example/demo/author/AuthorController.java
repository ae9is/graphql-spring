package com.example.demo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.book.Book;

@Controller
public class AuthorController {

  @Autowired
  AuthorRepository repo;

  @SchemaMapping
  public Author author(Book book) {
    return repo.getById(book.authorId());
  }
}
