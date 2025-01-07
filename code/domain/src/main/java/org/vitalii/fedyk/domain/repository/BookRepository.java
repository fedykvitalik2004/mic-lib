package org.vitalii.fedyk.domain.repository;

import org.vitalii.fedyk.domain.model.Book;

public interface BookRepository {
    Book findById(long id);
    void save(Book book);
    void delete(Book book);
}