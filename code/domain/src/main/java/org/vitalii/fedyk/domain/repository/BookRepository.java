package org.vitalii.fedyk.domain.repository;

import org.vitalii.fedyk.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAllByIds(List<Long> authorIds);

    boolean existsByAuthorId(Long authorId);

    long countByTitle(String title);

    Book save(Book book);

    Optional<Book> findById(long bookId);

    void delete(long bookId);
}