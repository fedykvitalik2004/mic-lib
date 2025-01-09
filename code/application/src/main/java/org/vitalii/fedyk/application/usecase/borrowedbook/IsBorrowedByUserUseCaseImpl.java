package org.vitalii.fedyk.application.usecase.borrowedbook;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.repository.BorrowedBookRepository;
import org.vitalii.fedyk.domain.usecase.borrowedbook.IsBorrowedByUserUseCase;

@Component
@AllArgsConstructor
public class IsBorrowedByUserUseCaseImpl implements IsBorrowedByUserUseCase {
    private BorrowedBookRepository borrowedBookRepository;

    @Override
    public boolean execute(long userId) {
        return borrowedBookRepository.existsByBorrowedBookIdUserId(userId);
    }
}
