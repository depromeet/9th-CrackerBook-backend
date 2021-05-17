package com.depromeet.crackerbook.service.book;

import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public List<Book> searchByName(String name){
        return bookRepository.findBooksByName(name);
    }
}