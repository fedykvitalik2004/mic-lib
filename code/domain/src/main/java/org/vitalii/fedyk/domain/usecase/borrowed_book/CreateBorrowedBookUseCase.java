package org.vitalii.fedyk.domain.usecase.borrowed_book;

import org.vitalii.fedyk.domain.model.BorrowedBook;

public interface CreateBorrowedBookUseCase {
    BorrowedBook execute(BorrowedBook borrowedBook);
}
