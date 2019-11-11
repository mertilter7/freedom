package com.freedom.controller;
import com.freedom.entity.Book;
import com.freedom.service.AuthorService;
import com.freedom.service.BookService;
import com.freedom.service.PublisherHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherHomeService publisherHomeService;

    @Autowired
    public BookController(BookService bookService,
                          AuthorService authorService,
                          PublisherHomeService publisherHomeService) {

        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherHomeService = publisherHomeService;
    }

    @GetMapping("book")
    public String show(Book book, Model model) {
        model.addAttribute("authors", authorService.findAllAuthor());
        model.addAttribute("publisherHomes", publisherHomeService.findAllPublisherHome());
        return "book-create";

    }

    @PostMapping("/books")
    public String save(@Valid Book book, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "book-create";
        }

        bookService.save(book);
        return "redirect:list";
    }

    @GetMapping("books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "book-list";
    }

    @GetMapping("book/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookService.delete(id);
        model.addAttribute("authors", bookService.findAllBooks());
        return "index";
    }

    @PostMapping("book/update/{id}")
    public String updateBook(@PathVariable("id") Long id , @Valid Book book, Model model) {
        bookService.save(book);
        model.addAttribute("book" , bookService.findAllBooks());
        return "redirect:list";
    }

}
