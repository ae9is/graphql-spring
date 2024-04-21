package com.example.demo.book;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

  @Autowired
  BookRepository repo;

  @QueryMapping
  public Book bookById(@Argument String id) {
    try {
      // ID (a String in GraphQL) should be a BigInt
      BigInteger bigId = new BigInteger(id);
      return repo.getById(bigId);
    } catch (Exception e) {
      return null;
    }
  }
}
