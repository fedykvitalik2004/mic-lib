package org.vitalii.fedyk.application.usecase.author;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.repository.AuthorRepository;
import org.vitalii.fedyk.domain.usecase.author.CreateAuthorUseCase;

@Component
@AllArgsConstructor
public class CreateAuthorUseCaseImpl implements CreateAuthorUseCase {
    private AuthorRepository authorRepository;

    @Override
    public Author execute(Author author) {
        return authorRepository.save(author);
    }
}
