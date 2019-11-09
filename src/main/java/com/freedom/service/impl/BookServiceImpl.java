package com.freedom.service.impl;

import com.freedom.entity.Book;
import com.freedom.repository.BookRepository;
import com.freedom.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Book getById(Long id) {
        Book book = bookRepository.getOne(id);
        return book;
    }

    @Override
    public Boolean delete(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
