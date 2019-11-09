package com.freedom.service;


import com.freedom.entity.Book;

public interface BookService {

        Book save(Book book);

        Book getById(Long id);

        Boolean delete (Long id);
}
