package org.vitalii.fedyk.infrastructure.hibernate.adapter;

import org.springframework.stereotype.Repository;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.repository.AuthorRepository;
import org.vitalii.fedyk.infrastructure.hibernate.repository.AuthorEntityRepository;

@Repository
public class JpaAuthorRepositoryAdapter implements AuthorRepository {
    private AuthorEntityRepository authorEntityRepository;

    public JpaAuthorRepositoryAdapter(AuthorEntityRepository authorEntityRepository) {
        this.authorEntityRepository = authorEntityRepository;
    }

    @Override
    public Author findById(Long authorId) {
        return authorEntityRepository.findById(authorId)
                .orElseThrow(() -> new NotFoundException("Author not found by id"));
    }

    @Override
    public Author save(Author author) {
        return null;
    }
}
