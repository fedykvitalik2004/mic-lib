package org.vitalii.fedyk.domain.usecase.book;

import org.vitalii.fedyk.domain.model.Book;

public interface UpdateBookUseCase {
    Book execute(long bookId, Book book);
}
