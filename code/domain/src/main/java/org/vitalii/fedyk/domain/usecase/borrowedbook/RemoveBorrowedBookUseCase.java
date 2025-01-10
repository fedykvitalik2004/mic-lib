package org.vitalii.fedyk.domain.usecase.borrowedbook;

public interface RemoveBorrowedBookUseCase {
    void execute(Long bookId, long userId);
}
