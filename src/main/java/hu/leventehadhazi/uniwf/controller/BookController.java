package hu.leventehadhazi.uniwf.controller;

import hu.leventehadhazi.uniwf.entity.BookEntity;
import hu.leventehadhazi.uniwf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public BookEntity addBook(@RequestBody BookEntity book) {
        return bookService.saveBook(book);
    }

    @PostMapping("/addbooks")
    public List<BookEntity> addBooks(@RequestBody List<BookEntity> books) {
        return bookService.saveBooks(books);
    }

    @GetMapping("/books")
    public List<BookEntity> findAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/bookbyid/{id}")
    public BookEntity findBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/bookbytitle/{title}")
    public BookEntity findBookByName(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @PutMapping("/update")
    public BookEntity updateBook(@RequestBody BookEntity book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

    @DeleteMapping("/deleteall")
    public String deleteAllBooks() {
        return bookService.deleteAllBooks();
    }
}
