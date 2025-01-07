package org.vitalii.fedyk.application.usecase;

import org.vitalii.fedyk.apirest.dto.CreateAuthorDto;
import org.vitalii.fedyk.domain.model.Author;

public interface CreateAuthorUseCase {
    Author execute (CreateAuthorDto createAuthorDto);
}
