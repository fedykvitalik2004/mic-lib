package org.vitalii.fedyk.application.usecase.borrowedbook;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.model.BorrowedBook;
import org.vitalii.fedyk.domain.repository.BorrowedBookRepository;
import org.vitalii.fedyk.domain.usecase.book.ReadBookUseCase;
import org.vitalii.fedyk.domain.usecase.borrowedbook.GetBorrowedBooksByUserIdUseCase;

import java.util.List;

@Component
@AllArgsConstructor
public class GetBorrowedBooksByUserIdUseCaseImpl implements GetBorrowedBooksByUserIdUseCase {
    private BorrowedBookRepository borrowedBookRepository;
    private ReadBookUseCase readBookUseCase;

    @Override
    public List<BorrowedBook> execute(long userId) {
        List<BorrowedBook> borrowedBooks = borrowedBookRepository.findByUserId(userId);
        borrowedBooks.forEach(o -> o.setBook(readBookUseCase.execute(o.getBook().getId())));
        return borrowedBooks;
    }
}
