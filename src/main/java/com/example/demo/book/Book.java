package com.example.demo.book;

import java.math.BigInteger;

public record Book(BigInteger id, String name, int pageCount, BigInteger authorId) {}
