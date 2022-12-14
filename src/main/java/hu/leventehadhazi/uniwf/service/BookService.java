package hu.leventehadhazi.uniwf.service;

import hu.leventehadhazi.uniwf.uito.BookUiTo;

import java.util.List;

public interface BookService {
    BookUiTo doSaveBook(BookUiTo bookUiTo);

    BookUiTo doGetBook(BookUiTo bookUiTo);

    List<BookUiTo> doFetchAllBooks();

    void doDeleteBook(BookUiTo bookUiTo);
}
