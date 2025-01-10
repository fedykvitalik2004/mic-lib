package org.vitalii.fedyk.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.infrastructure.entity.AuthorEntity;

@Mapper(componentModel = "spring")
public interface AuthorEntityMapper {
    AuthorEntity toEntity(Author author);
    @Mapping(target = "books", ignore = true)
    Author toModel(AuthorEntity authorEntity);
}
