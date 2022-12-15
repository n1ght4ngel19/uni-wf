package hu.leventehadhazi.uniwf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_table")
public class BookEntity {
    @Id
    @GeneratedValue
    private int id;
    private String bookTitle;
    private int publishDate;
    private double price;
}
