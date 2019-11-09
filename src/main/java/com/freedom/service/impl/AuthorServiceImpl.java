package com.freedom.service.impl;

import com.freedom.entity.Author;
import com.freedom.repository.AuthorRepository;
import com.freedom.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author saveAuthor(Author author) {
        if (author.getName() == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
        author = authorRepository.save(author);
        return author;
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public Boolean delete(Long id) {
        authorRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Author> findAllAuthor() {
        return  authorRepository.findAll();
    }
}



