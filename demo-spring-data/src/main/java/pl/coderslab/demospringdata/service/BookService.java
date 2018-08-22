package pl.coderslab.demospringdata.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import pl.coderslab.demospringdata.model.Book;
import pl.coderslab.demospringdata.model.Category;
import pl.coderslab.demospringdata.repository.BookRepository;
import pl.coderslab.demospringdata.repository.CategoryRepository;

import java.util.List;

@Service
public class BookService {

// wstrzyniecie
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }


    public Page<Book> getAll(Pageable pageable){
//        Book book = Book.builder().title("tytul").author("andrezej").build();
//        bookRepository.save(book);

        return bookRepository.findAll(pageable);
    }

    public Book addOne(Book book) {
        Category category = book.getCategory();

        Category fromDB = categoryRepository.findById(category.getId());
// sprawdzamy czy Id istnieje, aby uniknąć dopisywania nieistniejacych
        if (fromDB == null ) {
            category = categoryRepository.save(category);
            book.setCategory(category);
        }

        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByCategory(final Long id){
        Category fromDB = categoryRepository.findById(id);
        return bookRepository.findByCategory(fromDB);
    };

    public List<Book> findByCategory_Id(final Long id){
        return bookRepository.findByCategory_Id(id);
    };


    public void swapTitle (final String oldOne, final String newOne) {
        bookRepository.changeBookTitle(oldOne,newOne);
    }

    public List<Book> fingBookByTitle( final String title) {
        return bookRepository.fingBookByTitle(title);
    };

    public List<Book> findBookByCategory(final Long category) {
        Category category1 = categoryRepository.findById(category);
        return bookRepository.findBookByCategory(category1);
    };

    ////////////////////////////// zad 2-2

    public List<Book> findBookByRRating (final int a, final int b) {
        return bookRepository.findBookByRating(a,b);
    }

    public List<Book> findBookByPPublisher(final String p) {
        return bookRepository.findBookByPublisher(p);
    }

    public List <Book> findBookByB(final Long id) {
        return bookRepository.findBookByB(id);
    }

    ////////////////////////// zad 1-3

    public List<Book> findByAuthor(final String author){
        return bookRepository.findByAuthor(author);
    };

    public List<Book> findByPublisher(final String publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    public List<Book> findByRating(final int rating) {
        return bookRepository.findByRating(rating);
    }

    public Book findFirstByCategoryOrderByTitle(final Long id) {
        return bookRepository.findFirstByCategory_IdOrderByTitleAsc(id);
    }

    ////////////////////////// zad 2-4
    public void setRating (final int rating) {
        bookRepository.resetRating(rating);
    }
}
