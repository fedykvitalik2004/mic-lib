package org.vitalii.fedyk.application.usecase.borrowed_book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.repository.BorrowedBookRepository;
import org.vitalii.fedyk.domain.usecase.borrowed_book.IsBorrowedByBookUseCase;

@Component
@AllArgsConstructor
public class IsBorrowedByBookUseCaseImpl implements IsBorrowedByBookUseCase {
    private BorrowedBookRepository borrowedBookRepository;

    @Override
    public boolean execute(long bookId) {
        return borrowedBookRepository.existsByBorrowedBookIdBookId(bookId);
    }
}
