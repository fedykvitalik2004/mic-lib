package org.vitalii.fedyk.domain.usecase.author;

import org.vitalii.fedyk.domain.model.Author;

public interface CreateAuthorUseCase {
    Author execute(Author author);
}
