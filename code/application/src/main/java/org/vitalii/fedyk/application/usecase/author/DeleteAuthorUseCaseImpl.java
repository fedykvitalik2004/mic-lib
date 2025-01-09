package org.vitalii.fedyk.application.usecase.author;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.exception.OperationNotPermittedException;
import org.vitalii.fedyk.domain.repository.AuthorRepository;
import org.vitalii.fedyk.domain.usecase.author.DeleteAuthorUseCase;
import org.vitalii.fedyk.domain.usecase.book.AuthorHasBooksUseCase;

import static org.vitalii.fedyk.infrastructure.constant.ExceptionConstants.AUTHOR_CANNOT_BE_DELETED;
import static org.vitalii.fedyk.infrastructure.constant.ExceptionConstants.AUTHOR_NOT_FOUND_BY_ID;

@Component
@AllArgsConstructor
public class DeleteAuthorUseCaseImpl implements DeleteAuthorUseCase {
    private AuthorRepository authorRepository;
    private AuthorHasBooksUseCase authorHasBooksUseCase;

    @Override
    public void execute(long authorId) {
        if (!authorRepository.existsById(authorId)) {
            throw new NotFoundException(AUTHOR_NOT_FOUND_BY_ID.formatted(authorId));
        }
        if (authorHasBooksUseCase.execute(authorId)) {
            throw new OperationNotPermittedException(AUTHOR_CANNOT_BE_DELETED);
        }
        authorRepository.deleteById(authorId);
    }
}
