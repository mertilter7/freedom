package com.freedom.service.impl;

import com.freedom.entity.Author;
import com.freedom.entity.Book;
import com.freedom.repository.AuthorRepository;
import com.freedom.repository.BookRepository;
import com.freedom.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book save(Book book) {
        Author author = authorRepository.getOne(book.getAuthor().getId());
        book.setAuthor(author);
        book = bookRepository.save(book);
        return book;
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

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
