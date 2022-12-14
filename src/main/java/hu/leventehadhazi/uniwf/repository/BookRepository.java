package hu.leventehadhazi.uniwf.repository;

import hu.leventehadhazi.uniwf.entity.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDto, Long> {

}
