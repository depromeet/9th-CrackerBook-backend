package com.depromeet.crackerbook.domain.book.repository;

import com.depromeet.crackerbook.domain.book.BookLike;
import com.depromeet.crackerbook.domain.book.QBookLike;
import com.depromeet.crackerbook.domain.book.dto.BookLikeDto;
import com.depromeet.crackerbook.domain.book.dto.QBookLikeDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import static com.depromeet.crackerbook.domain.book.QBook.book;
import static com.depromeet.crackerbook.domain.book.QBookLike.bookLike;

public class BookLikeRepositoryCustomImpl implements BookLikeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public BookLikeRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public QueryResults<BookLikeDto> getBookLikeList(Long userId, Pageable pageable) {
        return queryFactory
                .select(new QBookLikeDto(
                        book.bookId
                        , book.name
                        , book.imageUrlBig
                        , book.authors
                ))
                .from(bookLike)
                .innerJoin(bookLike.book, book)
                .where(userIdEq(userId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(bookLike.createdAt.desc())
                .fetchResults();
    }

    @Override
    public Long getBookLikeId(Long userId, Long bookId) {
        return queryFactory
            .select(bookLike.bookLikeId)
            .from(bookLike)
            .where(userIdEq(userId).and(bookIdEq(bookId)))
            .fetchOne();
    }

    private BooleanExpression userIdEq(Long userId) {
        return bookLike.user.userId.eq(userId);
    }

    private BooleanExpression bookIdEq(Long bookId){
        return bookLike.book.bookId.eq(bookId);
    }
}
