package org.vitalii.fedyk.application.usecase.impl;

import org.springframework.stereotype.Service;
import org.vitalii.fedyk.apirest.dto.CreateAuthorDto;
import org.vitalii.fedyk.application.usecase.CreateAuthorUseCase;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.repository.AuthorRepository;
import org.vitalii.fedyk.infrastructure.hibernate.adapter.JpaAuthorRepositoryAdapter;

@Service
public class CreateAuthorUseCaseImpl implements CreateAuthorUseCase {
    private JpaAuthorRepositoryAdapter adapter;

    @Override
    public Author execute(CreateAuthorDto createAuthorDto) {

        return adapter.save(null);
    }
}
