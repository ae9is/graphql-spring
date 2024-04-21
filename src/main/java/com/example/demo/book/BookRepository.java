package com.example.demo.book;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

  @Autowired
  JdbcClient client;

  public Book getById(BigInteger id) {
    Optional<Book> res = client.sql("""
          SELECT
            book.book_id as id,
            book.title as name,
            book.numpages as pageCount,
            author.author_id as authorId
          FROM
            book,
            author,
            book_has_author as relation
          WHERE
            book.book_id = :book_id
            AND book.book_id = relation.book_id
            AND author.author_id = relation.author_id
          LIMIT 1
        """)
        .param("book_id", id)
        .query(Book.class)
        .optional();
    return res.isPresent() ? res.get() : null;
  }
}
