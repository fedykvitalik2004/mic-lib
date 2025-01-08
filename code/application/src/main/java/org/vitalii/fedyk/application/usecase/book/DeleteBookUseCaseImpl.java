package org.vitalii.fedyk.application.usecase.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.repository.BookRepository;
import org.vitalii.fedyk.domain.usecase.book.DeleteBookUseCase;

@Component
@AllArgsConstructor
public class DeleteBookUseCaseImpl implements DeleteBookUseCase {
    private BookRepository bookRepository;

    @Override
    public void execute(long userId) {
        bookRepository.delete(userId);
    }
}
