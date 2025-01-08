package org.vitalii.fedyk.domain.usecase.author;

import org.vitalii.fedyk.domain.model.Author;

public interface UpdateAuthorUseCase {
    Author execute(long userId, Author author);
}
