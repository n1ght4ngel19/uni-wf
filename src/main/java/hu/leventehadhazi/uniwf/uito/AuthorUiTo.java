package hu.leventehadhazi.uniwf.uito;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class AuthorUiTo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long authorId;
    private String authorName;
    private List<BookUiTo> bookUiToList;
}
