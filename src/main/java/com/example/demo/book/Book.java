package com.example.demo.book;

import java.util.HashMap;

public record Book(Long id, String name, int pageCount, HashMap<String, Object> details, Long authorId) {

  public Book(Long id, String name, int pageCount, HashMap<String, Object> details, Long authorId) {
    this.id = id;
    this.name = name;
    this.pageCount = pageCount;
    this.details = details;
    this.authorId = authorId;
  }
}
