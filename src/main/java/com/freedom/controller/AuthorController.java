package com.freedom.controller;
import com.freedom.entity.Author;
import com.freedom.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {

        this.authorService = authorService;
    }

    @GetMapping("author")
    public String showAuthor(Author author) {

        return "author-create";
    }

    @PostMapping("/authors")
    public String save(@Valid Author author, BindingResult result, Model model){

        if (result.hasErrors()){
            return "author-create";
        }

        authorService.saveAuthor(author);
        return "redirect:authors";
    }

    @GetMapping("authors")
    public String listAuthors(Model model){
        model.addAttribute("authors", authorService.findAllAuthor());
        return "author-list";
    }

    @GetMapping("author/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id, Model model){
        authorService.delete(id);
        model.addAttribute("authors", authorService.findAllAuthor());
        return "index";
    }

    @PostMapping("author/edit/{id}")
    public String updateAuthor(@PathVariable("id") Long id , @Valid Author author, Model model) {
        Author update = authorService.update(id, author);
        model.addAttribute("authors", authorService.findAllAuthor());
        return "author-list";
    }

    @GetMapping("author/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Author author = authorService.getById(id);
        model.addAttribute("author", author);
        return "author-update";
    }

}
