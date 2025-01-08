package org.vitalii.fedyk.domain.usecase.borrowed_book;

public interface RemoveBorrowedBookUseCase {
    void execute(long bookId, long userId);
}
