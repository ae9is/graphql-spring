package com.example.demo.author;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {

  @Autowired
  JdbcClient client;

  public Author getById(BigInteger id) {
    Optional<Author> res = client.sql("""
          SELECT
            author.author_id as id,
            author.firstname as firstName,
            author.lastname as lastName
          FROM
            author
          WHERE
            author.author_id = :author_id
          LIMIT 1
        """)
        .param("author_id", id)
        .query(Author.class)
        .optional();
    return res.isPresent() ? res.get() : null;
  }
}
