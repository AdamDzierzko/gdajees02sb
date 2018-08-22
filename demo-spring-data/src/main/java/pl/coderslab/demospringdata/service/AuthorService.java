package pl.coderslab.demospringdata.service;

import org.springframework.stereotype.Service;
import pl.coderslab.demospringdata.model.Author;
import pl.coderslab.demospringdata.model.Book;
import pl.coderslab.demospringdata.model.Category;
import pl.coderslab.demospringdata.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    ///////////////////////// zad 1-5

    public Author findByEmaill (final String email) {
        return authorRepository.findByEmail(email);
    }

    public Author findByPesell (final String pesel) {
        return authorRepository.findByPesel(pesel);
    }

    public List<Author> findByNamee (final String name) {
        return authorRepository.findByName(name);
    }

    //////////////////////// zad 2-3
    public List<Author> findAuthorByEmaill (final String a) {
        return authorRepository.findAuthorByEmail(a + "%");
    }

    public List<Author> findAuthorByPesell (final String a) {
        return authorRepository.findAuthorByPesel(a);
    }


    public Author addOne(final Author author) {

        return authorRepository.save(author);
    }
}
