package pl.coderslab.demospringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.demospringdata.model.Book;
import pl.coderslab.demospringdata.model.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>, BookRepositoryCustom
{

    Book findById(final Long id);
    List<Book> findByTitle(final String title);
    List<Book> findByCategory(final Category category);
    List<Book> findByCategory_Id(final Long id);

    @Query("select b from Book b where b.id = :id")
    Book findByIdCustom(@Param("id") final Long id);

    @Query("select b from Book b where b.title = :t")
    List<Book> fingBookByTitle(@Param("t") final String title);


    @Query("select b from Book b where b.category = :c")
    List<Book> findBookByCategory(@Param("c") final Category category);

    ////////////////////////zad 2-2

    @Query("select b from Book b where b.rating BETWEEN :a AND :b")
    List<Book> findBookByRating(@Param("a") final int a, @Param("b") final int b) ;

    @Query("select b from Book b where b.publisher = :p")
    List<Book> findBookByPublisher(@Param("p") final String p) ;

    @Query("select b from Book b where b.category.id = :c  ORDER BY b.title ASC ")
    List <Book> findBookByB (@Param("c") final Long id);

    ///////////////////////zad 1-3
    List<Book> findByAuthor(final String author);
    List<Book> findByPublisher(final String publisher);
    List<Book> findByRating(final int rating);
    Book findFirstByCategory_IdOrderByTitleAsc(final Long id);


}
