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
class IsBorrowedByUserUseCaseTest {
    @InjectMocks
    private IsBorrowedByUserUseCaseImpl isBorrowedByUserUseCase;
    @Mock
    private BorrowedBookRepository borrowedBookRepository;

    @Test
    void execute_BookBorrowed() {
        long userId = 1L;

        when(borrowedBookRepository.existsByBorrowedBookIdUserId(userId)).thenReturn(true);

        assertTrue(isBorrowedByUserUseCase.execute(userId));

        verify(borrowedBookRepository).existsByBorrowedBookIdUserId(userId);
    }

    @Test
    void execute_BookNotBorrowed() {
        long userId = 1L;

        when(borrowedBookRepository.existsByBorrowedBookIdUserId(userId)).thenReturn(false);

        assertFalse(isBorrowedByUserUseCase.execute(userId));

        verify(borrowedBookRepository).existsByBorrowedBookIdUserId(userId);
    }
}
