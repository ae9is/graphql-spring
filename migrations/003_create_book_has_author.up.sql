CREATE TABLE IF NOT EXISTS book_has_author (
  book_id BIGINT,
  author_id BIGINT,
  PRIMARY KEY (book_id, author_id),
  CONSTRAINT fk_book_has_author_book FOREIGN KEY(book_id) REFERENCES book(book_id),
  CONSTRAINT fk_book_has_author_author FOREIGN KEY(author_id) REFERENCES author(author_id)
);
COPY book_has_author FROM '/export/book_has_author.csv' WITH CSV DELIMITER E'\x1e' QUOTE E'\x1f' NULL AS '' HEADER;