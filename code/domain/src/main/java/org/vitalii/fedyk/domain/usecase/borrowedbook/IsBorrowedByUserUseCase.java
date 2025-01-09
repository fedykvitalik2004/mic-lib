package org.vitalii.fedyk.domain.usecase.borrowedbook;

public interface IsBorrowedByUserUseCase {
    boolean execute (long userId);
}
