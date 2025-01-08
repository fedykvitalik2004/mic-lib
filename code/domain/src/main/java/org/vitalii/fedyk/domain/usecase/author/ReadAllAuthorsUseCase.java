package org.vitalii.fedyk.domain.usecase.author;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vitalii.fedyk.domain.model.Author;

public interface ReadAllAuthorsUseCase {
    Page<Author> execute(Pageable pageable);
}
