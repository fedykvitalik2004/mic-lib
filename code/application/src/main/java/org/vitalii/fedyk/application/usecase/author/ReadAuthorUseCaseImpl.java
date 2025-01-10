package org.vitalii.fedyk.application.usecase.author;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.repository.AuthorRepository;
import org.vitalii.fedyk.domain.usecase.author.ReadAuthorUseCase;

import static org.vitalii.fedyk.domain.constant.ExceptionConstants.AUTHOR_NOT_FOUND_BY_ID;

@Component
@AllArgsConstructor
@Transactional
public class ReadAuthorUseCaseImpl implements ReadAuthorUseCase {
    private AuthorRepository authorRepository;

    @Override
    public Author execute(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new NotFoundException(AUTHOR_NOT_FOUND_BY_ID.formatted(authorId)));
    }
}
