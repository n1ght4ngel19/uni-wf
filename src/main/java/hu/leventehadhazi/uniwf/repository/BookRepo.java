package hu.leventehadhazi.uniwf.repository;

import hu.leventehadhazi.uniwf.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {
    BookEntity findBookEntityByBookTitle(String title);
}
