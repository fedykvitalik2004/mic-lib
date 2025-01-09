package org.vitalii.fedyk.domain.usecase.borrowedbook;

import org.vitalii.fedyk.domain.model.BorrowedBook;

public interface CreateBorrowedBookUseCase {
    BorrowedBook execute(BorrowedBook borrowedBook);
}
