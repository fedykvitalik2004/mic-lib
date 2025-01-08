package org.vitalii.fedyk.domain.usecase.author;

import org.vitalii.fedyk.domain.model.Author;

public interface ReadAuthorUseCase {
    Author execute(long userId);
}
