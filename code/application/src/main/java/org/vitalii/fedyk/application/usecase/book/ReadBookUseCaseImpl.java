package org.vitalii.fedyk.application.usecase.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.model.Book;
import org.vitalii.fedyk.domain.repository.BookRepository;
import org.vitalii.fedyk.domain.usecase.book.ReadBookUseCase;

import static org.vitalii.fedyk.infrastructure.constant.ExceptionConstants.BOOK_NOT_FOUND_BY_ID;

@Component
@AllArgsConstructor
public class ReadBookUseCaseImpl implements ReadBookUseCase {
    private BookRepository bookRepository;

    @Override
    public Book execute(long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BOOK_NOT_FOUND_BY_ID.formatted(bookId)));
    }
}
