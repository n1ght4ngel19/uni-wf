package hu.leventehadhazi.uniwf.uito;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class BookUiTo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long bookId;
    private String title;
    private String author;
    private String publishDate;
    private AuthorUiTo authorUiTo;
}
