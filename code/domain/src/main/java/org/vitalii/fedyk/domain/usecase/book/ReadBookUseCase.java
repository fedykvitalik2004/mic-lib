package org.vitalii.fedyk.domain.usecase.book;

import org.vitalii.fedyk.domain.model.Book;

public interface ReadBookUseCase {
    Book execute(long bookId);
}