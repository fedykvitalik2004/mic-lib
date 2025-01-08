package org.vitalii.fedyk.apirest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import org.vitalii.fedyk.apirest.dto.CreateAuthorDto;
import org.vitalii.fedyk.apirest.dto.PaginationDto;
import org.vitalii.fedyk.apirest.dto.ReadAuthorDto;
import org.vitalii.fedyk.apirest.dto.ReadAuthorsDto;
import org.vitalii.fedyk.apirest.mapper.AuthorMapper;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.usecase.author.CreateAuthorUseCase;
import org.vitalii.fedyk.domain.usecase.author.ReadAllAuthorsUseCase;
import org.vitalii.fedyk.domain.usecase.author.ReadAuthorUseCase;

@RestController
public class AuthorController implements AuthorsApi {
    private ReadAllAuthorsUseCase readAllAuthorsUseCase;
    private ReadAuthorUseCase readAuthorUseCase;
    private CreateAuthorUseCase createAuthorUseCase;
    private AuthorMapper authorMapper;

    public AuthorController(ReadAllAuthorsUseCase readAllAuthorsUseCase, ReadAuthorUseCase readAuthorUseCase, CreateAuthorUseCase createAuthorUseCase, AuthorMapper authorMapper) {
        this.readAllAuthorsUseCase = readAllAuthorsUseCase;
        this.readAuthorUseCase = readAuthorUseCase;
        this.createAuthorUseCase = createAuthorUseCase;
        this.authorMapper = authorMapper;
    }

    @Override
    public ReadAuthorDto createAuthor(CreateAuthorDto createAuthorDto) {
        return authorMapper.toReadAuthorDto(
                createAuthorUseCase.execute(authorMapper.toAuthor(createAuthorDto))
        );
    }

    @Override
    public void deleteAuthor(Long authorId) {

    }

    @Override
    public ReadAuthorsDto getAllAuthors(Pageable pageable) {
        return createAuthorsDto(readAllAuthorsUseCase.execute(pageable));
    }

    private ReadAuthorsDto createAuthorsDto(final Page<Author> authors) {
        ReadAuthorsDto readAuthorsDto = new ReadAuthorsDto();
        readAuthorsDto.setAuthors(authors.getContent().stream().map(authorMapper::toReadAuthorDto).toList());
        final PaginationDto paginationDto = new PaginationDto();
        paginationDto.setPageNumber(authors.getNumber());
        paginationDto.setPageSize(authors.getSize());
        paginationDto.setTotalNumberOfPages(authors.getTotalPages());
        readAuthorsDto.setPagination(paginationDto);
        return readAuthorsDto;
    }

    @Override
    public ReadAuthorDto getAuthorById(Long authorId) {
        return authorMapper.toReadAuthorDto(readAuthorUseCase.execute(authorId));
    }

    @Override
    public ReadAuthorDto updateAuthor(Long authorId, CreateAuthorDto createAuthorDto) {
        return null;
    }
}
