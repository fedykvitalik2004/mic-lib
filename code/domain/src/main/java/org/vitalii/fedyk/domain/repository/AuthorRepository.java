package org.vitalii.fedyk.domain.repository;

import org.springframework.data.domain.Page;
import org.vitalii.fedyk.domain.model.Author;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);
    Optional<Author> findById(long userId);
    boolean existsById(long authorId);
    Page<Author> findAll(Pageable pageable);
    void deleteById(long authorId);
}