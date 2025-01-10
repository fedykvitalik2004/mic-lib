package org.vitalii.fedyk.application.usecase.author;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.repository.AuthorRepository;
import org.vitalii.fedyk.domain.usecase.author.ReadAllAuthorsUseCase;

@Component
@AllArgsConstructor
@Transactional
public class ReadAllAuthorsUseCaseImpl implements ReadAllAuthorsUseCase {
    private AuthorRepository authorRepository;

    @Override
    public Page<Author> execute(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }
}