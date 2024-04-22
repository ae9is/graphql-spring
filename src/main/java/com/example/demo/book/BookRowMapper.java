package com.example.demo.book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class BookRowMapper implements RowMapper<Book> {
  static final BookRowMapper INSTANCE = new BookRowMapper();
  final TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {};
  final JsonMapper mapper = new JsonMapper();

  BookRowMapper() {
    mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
  }

  public static BookRowMapper getInstance() {
    return INSTANCE;
  }

  @Override
  public Book mapRow(@Nullable ResultSet rs, int rowNum) throws SQLException {
    if (rs == null) {
      return null;
    }
    String jsonString = rs.getString("details");
    HashMap<String, Object> details;
    try {
      details = mapper.readValue(jsonString, typeRef);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      details = null;
    }
    return new Book(
      rs.getLong("id"),
      rs.getString("name"),
      rs.getInt("pageCount"),
      details,
      rs.getLong("authorId")
    );
  }
}