package org.vitalii.fedyk.domain.usecase.borrowed_book;

import org.vitalii.fedyk.domain.model.BorrowedBook;

import java.util.List;

public interface GetBorrowedBooksByUserIdUseCase {
    List<BorrowedBook> execute(long userId);
}
