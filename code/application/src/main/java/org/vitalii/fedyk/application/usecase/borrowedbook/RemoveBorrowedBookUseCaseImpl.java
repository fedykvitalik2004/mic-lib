package org.vitalii.fedyk.application.usecase.borrowedbook;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.model.BorrowedBook;
import org.vitalii.fedyk.domain.repository.BorrowedBookRepository;
import org.vitalii.fedyk.domain.usecase.borrowedbook.RemoveBorrowedBookUseCase;
import org.vitalii.fedyk.domain.vo.BorrowedBookId;

import static org.vitalii.fedyk.domain.constant.ExceptionConstants.BORROWED_BOOK_NOT_FOUND;

@Component
@AllArgsConstructor
public class RemoveBorrowedBookUseCaseImpl implements RemoveBorrowedBookUseCase {
    private BorrowedBookRepository borrowedBookRepository;

    @Override
    public void execute(Long bookId, long userId) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(new BorrowedBookId(bookId, userId))
                .orElseThrow(() -> new NotFoundException(BORROWED_BOOK_NOT_FOUND));
        borrowedBookRepository.delete(new BorrowedBookId(bookId, userId));
    }
}
