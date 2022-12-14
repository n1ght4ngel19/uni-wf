package hu.leventehadhazi.uniwf.service;

import hu.leventehadhazi.uniwf.uito.AuthorUiTo;

import java.util.List;

public interface AuthorService {
    List<AuthorUiTo> getAllAuthors(AuthorUiTo authorUiTo);

    AuthorUiTo getAuthor(AuthorUiTo authorUiTo);
}
