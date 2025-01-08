package org.vitalii.fedyk.apirest.mapper;

import org.mapstruct.Mapper;
import org.vitalii.fedyk.apirest.dto.CreateAuthorDto;
import org.vitalii.fedyk.apirest.dto.ReadAuthorDto;
import org.vitalii.fedyk.domain.model.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(CreateAuthorDto createAuthorDto);
    ReadAuthorDto toReadAuthorDto(Author author);
}