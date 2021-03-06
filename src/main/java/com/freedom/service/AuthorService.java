package com.freedom.service;

import com.freedom.entity.Author;

import java.util.List;

public interface AuthorService {

    Author saveAuthor(Author author);

    Author getById(Long id);

    Boolean delete(Long id);

    Author update(Long id, Author author);

    List<Author> findAllAuthor();
}
