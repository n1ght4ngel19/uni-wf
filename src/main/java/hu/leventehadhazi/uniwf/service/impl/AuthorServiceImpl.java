package hu.leventehadhazi.uniwf.service.impl;

import hu.leventehadhazi.uniwf.entity.AuthorDto;
import hu.leventehadhazi.uniwf.repository.AuthorRepository;
import hu.leventehadhazi.uniwf.service.AuthorService;
import hu.leventehadhazi.uniwf.uito.AuthorUiTo;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<AuthorUiTo> getAllAuthors(AuthorUiTo authorUiTo) {
        List<AuthorUiTo> authorUiToList = new ArrayList<>();
        List<AuthorDto> authorDtoList = authorRepository.findAll();

        authorDtoList.forEach(authorDto -> {
            AuthorUiTo tmpUiTo = new AuthorUiTo();

            BeanUtils.copyProperties(authorDto, tmpUiTo);
            authorUiToList.add(tmpUiTo);
        });

        return authorUiToList;
    }

    @Override
    public AuthorUiTo getAuthor(AuthorUiTo authorUiTo) {
        System.out.println("> " + authorUiTo.getAuthorName());
        AuthorDto dto = authorRepository.findAuthorDtoByAuthorName(authorUiTo.getAuthorName());
        AuthorUiTo uiTo = new AuthorUiTo();

        BeanUtils.copyProperties(dto, uiTo);

        return uiTo;
    }
}
