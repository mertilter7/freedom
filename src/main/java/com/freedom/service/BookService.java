package com.freedom.service;


import com.freedom.entity.Book;

import java.util.List;

public interface BookService {

        Book save(Book book);

        Book getById(Long id);

        Boolean delete (Long id);

        List<Book> findAllBooks();

}
