package org.vitalii.fedyk.api_rest.mapper;

import org.mapstruct.Mapper;
import org.vitalii.fedyk.api_rest.generated.dto.CreateAuthorDto;
import org.vitalii.fedyk.api_rest.generated.dto.ReadAuthorDto;
import org.vitalii.fedyk.domain.model.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(CreateAuthorDto createAuthorDto);
    ReadAuthorDto toReadAuthorDto(Author author);
}