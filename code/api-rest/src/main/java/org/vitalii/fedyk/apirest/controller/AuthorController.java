package org.vitalii.fedyk.apirest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.vitalii.fedyk.apirest.dto.CreateAuthorDto;
import org.vitalii.fedyk.apirest.dto.ReadAuthorDto;
import org.vitalii.fedyk.apirest.dto.ReadAuthorsDto;
import org.springframework.data.domain.Pageable;

@RestController
public class AuthorController implements AuthorsApi {

    @Override
    public ReadAuthorDto createAuthor(CreateAuthorDto createAuthorDto) {
        return null;
    }

    @Override
    public void deleteAuthor(Long authorId) {

    }

    @Override
    public ReadAuthorsDto getAllAuthors(Pageable pageable) {
        return null;
    }

    @Override
    public ReadAuthorDto getAuthorById(Long authorId) {
        return null;
    }

    @Override
    public ReadAuthorDto updateAuthor(Long authorId, CreateAuthorDto createAuthorDto) {
        return null;
    }
}
