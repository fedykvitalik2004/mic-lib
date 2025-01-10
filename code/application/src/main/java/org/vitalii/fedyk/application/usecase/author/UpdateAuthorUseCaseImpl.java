package org.vitalii.fedyk.application.usecase.author;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.repository.AuthorRepository;
import org.vitalii.fedyk.domain.usecase.author.UpdateAuthorUseCase;

import static org.vitalii.fedyk.domain.constant.ExceptionConstants.AUTHOR_NOT_FOUND_BY_ID;

@Component
@AllArgsConstructor
@Transactional
public class UpdateAuthorUseCaseImpl implements UpdateAuthorUseCase {
    private AuthorRepository authorRepository;

    @Override
    public Author execute(Long authorId, Author author) {
        Author existingAuthor = authorRepository.findById(authorId)
                .orElseThrow(() -> new NotFoundException(AUTHOR_NOT_FOUND_BY_ID.formatted(authorId)));
        existingAuthor.update(author);
        return authorRepository.save(existingAuthor);
    }
}
