package pl.coderslab.demospringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.demospringdata.model.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository <Author,Long> {


    ///////////////////////// zad 1-5
    Author findByEmail (final String email);
    Author findByPesel (final String pesel);
    List<Author> findByName (final String name);

    ////////////////////////// zad 2-3
    @Query("select d from Author d where d.email like :a")
    List<Author> findAuthorByEmail (@Param("a")final String a);

    @Query("select d from Author d where d.pesel like ':a%'")
    List<Author> findAuthorByPesel (@Param("a")final String a);
}
