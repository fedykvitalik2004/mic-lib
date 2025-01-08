package org.vitalii.fedyk.infrastructure.adapter;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.repository.AuthorRepository;
import org.vitalii.fedyk.infrastructure.entity.AuthorEntity;
import org.vitalii.fedyk.infrastructure.mapper.AuthorEntityMapper;
import org.vitalii.fedyk.infrastructure.repository.AuthorEntityRepository;

import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaAuthorRepositoryAdapter implements AuthorRepository {
    private AuthorEntityRepository authorEntityRepository;
    private AuthorEntityMapper authorEntityMapper;

    @Override
    public Author save(Author author) {
        final AuthorEntity authorEntity = authorEntityMapper.toEntity(author);
        return authorEntityMapper.toModel(authorEntityRepository.save(authorEntity));
    }

    @Override
    public Optional<Author> findById(final long userId) {
        return authorEntityRepository.findById(userId)
                .map(o -> authorEntityMapper.toModel(o));
    }

    @Override
    public boolean existsById(long authorId) {
        return authorEntityRepository.existsById(authorId);
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return authorEntityRepository.findAll(pageable)
                .map(o -> authorEntityMapper.toModel(o));
    }

    @Override
    public void deleteById(long authorId) {
        authorEntityRepository.deleteById(authorId);
    }
}
