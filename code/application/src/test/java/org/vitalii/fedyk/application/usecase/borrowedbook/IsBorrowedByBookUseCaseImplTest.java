package org.vitalii.fedyk.application.usecase.borrowedbook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.vitalii.fedyk.domain.repository.BorrowedBookRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IsBorrowedByBookUseCaseImplTest {
    @InjectMocks
    private IsBorrowedByBookUseCaseImpl isBorrowedByBookUseCase;
    @Mock
    private BorrowedBookRepository borrowedBookRepository;

    @Test
    void execute_BookBorrowed() {
        long bookId = 1L;

        when(borrowedBookRepository.existsByBorrowedBookIdBookId(bookId)).thenReturn(true);

        assertTrue(isBorrowedByBookUseCase.execute(bookId));

        verify(borrowedBookRepository).existsByBorrowedBookIdBookId(bookId);
    }

    @Test
    void execute_BookNotBorrowed() {
        long bookId = 1L;

        when(borrowedBookRepository.existsByBorrowedBookIdBookId(bookId)).thenReturn(false);

        assertFalse(isBorrowedByBookUseCase.execute(bookId));

        verify(borrowedBookRepository).existsByBorrowedBookIdBookId(bookId);
    }
}
