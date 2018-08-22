package pl.coderslab.demospringdata.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.demospringdata.model.Author;
import pl.coderslab.demospringdata.model.Book;
import pl.coderslab.demospringdata.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    ///////////////////////////////////// zad 1-5

    @GetMapping("/byEmail")
    public Author findByEmail(final String email) {
        return authorService.findByEmaill(email);
    }

    @GetMapping("/byPesel")
    public Author findByPesel(final String pesel) {
        return authorService.findByPesell(pesel);
    }

    @GetMapping("/byName")
    public List<Author> findByName(final String name) {
        return authorService.findByNamee(name);
    }

    ///////////////////////////////// zad 2-3

    @GetMapping("byEmailPoczatek")
    public List<Author> findAuthorbyEmail(final String a) {
        return authorService.findAuthorByEmaill(a);
    }

    @GetMapping("byPelselPoczatek")
    public List<Author> findAuthorbyPesel(final String a) {
        return authorService.findAuthorByPesell(a);
    }

    @PostMapping
    public Author addOne(@RequestBody final Author author) {
        return authorService.addOne(author);
    }
}
