package org.vitalii.fedyk.application.usecase.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.repository.BookRepository;
import org.vitalii.fedyk.domain.usecase.book.AuthorHasBooksUseCase;

@Component
@AllArgsConstructor
public class AuthorHasBooksUseCaseImpl implements AuthorHasBooksUseCase {
    private BookRepository bookRepository;

    @Override
    public boolean execute(long authorId) {
        return bookRepository.existsByAuthorId(authorId);
    }
}
