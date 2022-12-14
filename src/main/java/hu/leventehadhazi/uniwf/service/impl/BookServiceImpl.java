package hu.leventehadhazi.uniwf.service.impl;

import hu.leventehadhazi.uniwf.entity.AuthorDto;
import hu.leventehadhazi.uniwf.entity.BookDto;
import hu.leventehadhazi.uniwf.repository.BookRepository;
import hu.leventehadhazi.uniwf.service.BookService;
import hu.leventehadhazi.uniwf.uito.AuthorUiTo;
import hu.leventehadhazi.uniwf.uito.BookUiTo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional(readOnly = false)
    public BookUiTo doSaveBook(BookUiTo bookUiTo) {
        BookDto dto = UiToToDto(bookUiTo);
        dto = bookRepository.save(dto);
        BeanUtils.copyProperties(dto, bookUiTo);
        dtoToUiTo(bookUiTo, dto);

        return bookUiTo;
    }

    @Override
    public BookUiTo doGetBook(BookUiTo bookUiTo) {
        if (null != bookUiTo.getBookId()) {
            BookDto dto = new BookDto();

            BeanUtils.copyProperties(bookUiTo, dto);
            dto = bookRepository.getOne(dto.getBookId());

            BeanUtils.copyProperties(dto, bookUiTo);
        }

        return bookUiTo;
    }

    @Override
    public void doDeleteBook(BookUiTo bookUiTo) {
        bookRepository.deleteById(bookUiTo.getBookId());
    }

    @Override
    public List<BookUiTo> doFetchAllBooks() {
        List<BookDto> bookDtoList = bookRepository.findAll();
        List<BookUiTo> bookUiToList = new ArrayList<>();
        bookDtoList.forEach(dto -> {
            BookUiTo tmpUiTO = new BookUiTo();
            System.out.println(dto.getAuthorDto());
            BeanUtils.copyProperties(dto, tmpUiTO);

            dtoToUiTo(tmpUiTO, dto);
            bookUiToList.add(tmpUiTO);
        });

        return bookUiToList;
    }

    private void dtoToUiTo(BookUiTo bookUiTo, BookDto bookDto) {
        AuthorUiTo uiTo = new AuthorUiTo();
        BeanUtils.copyProperties(bookDto.getAuthorDto(), uiTo);
        bookUiTo.setAuthorUiTo(uiTo);
    }

    private BookDto UiToToDto(BookUiTo bookUiTo) {
        BookDto dto = new BookDto();
        AuthorDto authorDto = new AuthorDto();
        BeanUtils.copyProperties(bookUiTo, dto);
        BeanUtils.copyProperties(bookUiTo.getAuthorUiTo(), authorDto);
        dto.setAuthorDto(authorDto);
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(dto);
        authorDto.getBookDtoList().addAll(bookDtoList);

        return dto;
    }
}
