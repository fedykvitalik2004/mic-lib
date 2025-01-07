package org.vitalii.fedyk.domain.repository;

import org.vitalii.fedyk.domain.model.Author;

public interface AuthorRepository {
    Author findById(Long authorId);
    Author save(Author author);
}
