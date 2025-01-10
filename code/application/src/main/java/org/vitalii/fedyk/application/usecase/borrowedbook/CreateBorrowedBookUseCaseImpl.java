package org.vitalii.fedyk.application.usecase.borrowedbook;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.OperationNotPermittedException;
import org.vitalii.fedyk.domain.model.Book;
import org.vitalii.fedyk.domain.model.BorrowedBook;
import org.vitalii.fedyk.domain.repository.BookRepository;
import org.vitalii.fedyk.domain.repository.BorrowedBookRepository;
import org.vitalii.fedyk.domain.usecase.book.ReadBookUseCase;
import org.vitalii.fedyk.domain.usecase.borrowedbook.CreateBorrowedBookUseCase;

import java.time.ZonedDateTime;

import static org.vitalii.fedyk.domain.constant.ExceptionConstants.BOOK_NOT_FOUND_BY_ID;
import static org.vitalii.fedyk.domain.constant.ExceptionConstants.BORROWED_BOOK_ALREADY_EXISTS;

@Component
@AllArgsConstructor
public class CreateBorrowedBookUseCaseImpl implements CreateBorrowedBookUseCase {
    private BorrowedBookRepository borrowedBookRepository;
    private ReadBookUseCase readBookUseCase;
    private BookRepository bookRepository;

    @Override
    public BorrowedBook execute(BorrowedBook borrowedBook) {
        if (borrowedBookRepository.existsById(borrowedBook.getId())) {
            throw new OperationNotPermittedException(BORROWED_BOOK_ALREADY_EXISTS);
        }
        final Book existingBook = bookRepository.findById(borrowedBook.getId().getBookId())
                .orElseThrow(() -> new IllegalArgumentException(
                        BOOK_NOT_FOUND_BY_ID.formatted(borrowedBook.getId().getBookId())));
        //todo: check if the user exists
        existingBook.addBorrowedBook(borrowedBook);
        borrowedBook.setBorrowDate(ZonedDateTime.now());
        return borrowedBookRepository.save(borrowedBook);
    }
}
