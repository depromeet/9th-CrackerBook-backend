package com.depromeet.crackerbook.domain.book.repository;

import com.depromeet.crackerbook.domain.book.dto.BookSearchDto;
import com.depromeet.crackerbook.domain.book.dto.QBookSearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.depromeet.crackerbook.domain.book.QBook.book;

import javax.persistence.EntityManager;
import org.springframework.util.ObjectUtils;

public class BookRepositoryCustomImpl implements BookRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public BookRepositoryCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public QueryResults<BookSearchDto> findBookByName(String name) {
        return queryFactory
            .select(new QBookSearchDto(
                book.bookId,
                book.name,
                book.imageUrlBig.coalesce(book.imageUrlSmall),
                book.publisher,
                book.authors,
                book.isbnLong,
                book.isbnShort,
                book.publishedAt
            ))
            .from(book)
            .where(book.name.contains(name))
            .fetchResults();
    }

    @Override
    public BookSearchDto findBookByIsbn(String isbnLong, String isbnShort) {
        return queryFactory
            .select(new QBookSearchDto(
                book.bookId,
                book.name,
                book.imageUrlBig.coalesce(book.imageUrlSmall),
                book.publisher,
                book.authors,
                book.isbnLong,
                book.isbnShort,
                book.publishedAt
            ))
            .from(book)
            .where(isbnLongEq(isbnLong), isbnShortEq(isbnShort))
            .fetchOne();
    }

    private BooleanExpression isbnLongEq(String isbnLong) {
        if(ObjectUtils.isEmpty(isbnLong)){
            return null;
        }
        return book.isbnLong.eq(isbnLong);
    }

    private BooleanExpression isbnShortEq(String isbnShort){
        if(ObjectUtils.isEmpty(isbnShort)){
            return null;
        }
        return book.isbnShort.eq(isbnShort);
    }
}