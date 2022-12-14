package hu.leventehadhazi.uniwf.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "BOOK_INFO")
@NamedQuery(name = "BookDto.findAll", query = "SELECT a from BookDto a")
public class BookDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "AUTHOR", nullable = false)
    private String author;
    @Column(name = "PUBLISH_DATE", nullable = false)
    private String publishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorDto authorDto;
}
