package pl.coderslab.demospringdata.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.demospringdata.model.Book;
import pl.coderslab.demospringdata.model.Category;
import pl.coderslab.demospringdata.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping
//    public List<Book> getAll() {
//        return bookService.getAll();
//    }

    @GetMapping
    public Page<Book> getAll(final Pageable pageable) {
        return bookService.getAll(pageable);
    }

    @PostMapping
    public Book addOne(@RequestBody final Book book) {
        return bookService.addOne(book);
    }

    @GetMapping("/{id}")
    public Book getByID(@PathVariable("id") final Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/byTitle")
    public List<Book> getByTitle(@RequestParam final String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping("/byCategory")
    public List<Book> findByCategory(@RequestParam final Long id) {
        return bookService.findByCategory(id);
    }

    @GetMapping("/byCategoryId")
    public List<Book> findByCategory_Id(@RequestParam final Long id) {
        return bookService.findByCategory_Id(id);
    }


    @GetMapping("/changeTitle")
    public void changeTitle(@RequestParam final String oldTitle,
                            @RequestParam final String newTitle) {
        bookService.swapTitle(oldTitle, newTitle);
    }

    @GetMapping("/fingBookByTitle")
    public List<Book> fingBookkByTitle(@RequestParam final String title) {
        return bookService.fingBookByTitle(title);
    }

    @GetMapping("/findBookByCategory")
    public List<Book> findBookByCategory(@RequestParam final Long id) {

        return bookService.findBookByCategory(id);
    }

    /////////////////////// zad 2-2

    @GetMapping("/fingBookByRating")
    public List<Book> findBookByRating(@RequestParam final int a,
                                       @RequestParam final int b) {
        return bookService.findBookByRRating(a, b);
    }

    @GetMapping("/findBookByPublisher")
    public List<Book> findBookByPublishers(@RequestParam final String p) {
        return bookService.findBookByPPublisher(p);
    }

    @GetMapping("/findBookByB")
    public List <Book> findBookByB(@RequestParam final Long id) {
        return bookService.findBookByB(id);
    }

    ///////////////////// zad 1-3

    @GetMapping("/byAuthor")
    public List<Book> findByAuthor(@RequestParam final String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/byPublisher")
    public List<Book> findByPublisher(@RequestParam final String publisher) {
        return bookService.findByPublisher(publisher);
    }

    @GetMapping("/byRating")
    public List<Book> findByRating(@RequestParam final int rating) {
        return bookService.findByRating(rating);
    }

    @GetMapping("/byCategoryAndSort")
    public Book findByCategoryAndSort(@RequestParam final Long id) {
        return bookService.findFirstByCategoryOrderByTitle(id);
    }

    @GetMapping("/byOwn")
    public void setRating(@RequestParam final int rating) {
        bookService.setRating(rating);
    }

}
