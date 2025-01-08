package org.vitalii.fedyk.domain.usecase.borrowed_book;

public interface IsBorrowedByBookUseCase {
    boolean execute(long bookId);
}
