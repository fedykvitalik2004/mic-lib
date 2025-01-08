package org.vitalii.fedyk.application.usecase.borrowed_book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.model.BorrowedBook;
import org.vitalii.fedyk.domain.repository.BorrowedBookRepository;
import org.vitalii.fedyk.domain.usecase.borrowed_book.RemoveBorrowedBookUseCase;
import org.vitalii.fedyk.domain.vo.BorrowedBookId;

import static org.vitalii.fedyk.infrastructure.constant.ExceptionConstants.BORROWED_BOOK_NOT_FOUND;

@Component
@AllArgsConstructor
public class RemoveBorrowedBookUseCaseImpl implements RemoveBorrowedBookUseCase {
    private BorrowedBookRepository borrowedBookRepository;

    @Override
    public void execute(long bookId, long userId) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(new BorrowedBookId(bookId, userId))
                .orElseThrow(() -> new NotFoundException(BORROWED_BOOK_NOT_FOUND));
        borrowedBookRepository.delete(new BorrowedBookId(bookId, userId));
    }
}
