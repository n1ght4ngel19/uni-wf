package hu.leventehadhazi.uniwf.repository;

import hu.leventehadhazi.uniwf.entity.AuthorDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorDto, Long> {
    AuthorDto findAuthorDtoByAuthorName(String authorName);
}
