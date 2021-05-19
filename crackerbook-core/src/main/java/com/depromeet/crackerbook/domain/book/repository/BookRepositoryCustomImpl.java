package com.depromeet.crackerbook.domain.book.repository;

import com.depromeet.crackerbook.domain.book.Book;
import com.depromeet.crackerbook.domain.book.QBook;
import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import com.depromeet.crackerbook.domain.book.dto.QBookSearchDto;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import org.springframework.util.StringUtils;

import static com.depromeet.crackerbook.domain.book.QBook.book;

import javax.persistence.EntityManager;

public class BookRepositoryCustomImpl implements BookRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public BookRepositoryCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public QueryResults<BookSearchDto> findBookByName(String name) {
        return queryFactory
                .select(new QBookSearchDto(
                        book.name,
                        book.imageUrlBig.coalesce(book.imageUrlSmall),
                        book.publisher,
                        book.authors,
                        book.publishedAt
                ))
                .from(book)
                .where(book.name.contains(name))
                .fetchResults();
    }
}
