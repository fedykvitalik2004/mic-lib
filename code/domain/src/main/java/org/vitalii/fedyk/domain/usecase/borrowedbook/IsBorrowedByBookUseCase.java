package org.vitalii.fedyk.domain.usecase.borrowedbook;

public interface IsBorrowedByBookUseCase {
    boolean execute(Long bookId);
}
