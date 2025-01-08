package org.vitalii.fedyk.domain.usecase.borrowed_book;

public interface IsBorrowedByUserUseCase {
    boolean execute (long userId);
}
