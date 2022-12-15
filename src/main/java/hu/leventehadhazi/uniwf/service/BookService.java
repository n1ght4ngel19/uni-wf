package hu.leventehadhazi.uniwf.service;

import hu.leventehadhazi.uniwf.entity.BookEntity;
import hu.leventehadhazi.uniwf.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public BookEntity saveBook(BookEntity book) {
        return bookRepo.save(book);
    }

    public List<BookEntity> saveBooks(List<BookEntity> books) {
        return bookRepo.saveAll(books);
    }

    public List<BookEntity> getBooks() {
        return bookRepo.findAll();
    }

    public BookEntity getBookById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    public BookEntity getBookByTitle(String title) {
        return bookRepo.findBookEntityByBookTitle(title);
    }

    public String deleteBook(int id) {
        bookRepo.deleteById(id);

        return "Book removed: " + id;
    }

    public String deleteAllBooks() {
        bookRepo.deleteAll();

        return "Removed all books";
    }

    public BookEntity updateBook(BookEntity book) {
        BookEntity existingBook = bookRepo.findById(book.getId()).orElse(null);
        existingBook.setBookTitle(book.getBookTitle());
        existingBook.setBookAuthor(book.getBookAuthor());
        existingBook.setPublishDate(book.getPublishDate());
        existingBook.setPrice(book.getPrice());

        return bookRepo.save(existingBook);
    }
}
