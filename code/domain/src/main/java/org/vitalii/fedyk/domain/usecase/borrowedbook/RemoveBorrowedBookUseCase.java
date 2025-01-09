package org.vitalii.fedyk.domain.usecase.borrowedbook;

public interface RemoveBorrowedBookUseCase {
    void execute(long bookId, long userId);
}
