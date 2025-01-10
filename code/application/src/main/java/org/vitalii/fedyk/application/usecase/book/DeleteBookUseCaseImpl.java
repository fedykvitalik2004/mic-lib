package org.vitalii.fedyk.application.usecase.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.exception.OperationNotPermittedException;
import org.vitalii.fedyk.domain.model.Book;
import org.vitalii.fedyk.domain.repository.BookRepository;
import org.vitalii.fedyk.domain.usecase.book.DeleteBookUseCase;
import org.vitalii.fedyk.domain.usecase.borrowedbook.IsBorrowedByBookUseCase;

import static org.vitalii.fedyk.domain.constant.ExceptionConstants.BOOK_CANNOT_BE_DELETED;
import static org.vitalii.fedyk.domain.constant.ExceptionConstants.BOOK_NOT_FOUND_BY_ID;

@Component
@AllArgsConstructor
public class DeleteBookUseCaseImpl implements DeleteBookUseCase {
    private final IsBorrowedByBookUseCase isBorrowedByBookUseCase;
    private BookRepository bookRepository;

    @Override
    public void execute(Long bookId) {
        if (isBorrowedByBookUseCase.execute(bookId)) {
            throw new OperationNotPermittedException(BOOK_CANNOT_BE_DELETED);
        }
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BOOK_NOT_FOUND_BY_ID.formatted(bookId)));
        bookRepository.delete(bookId);
    }
}
