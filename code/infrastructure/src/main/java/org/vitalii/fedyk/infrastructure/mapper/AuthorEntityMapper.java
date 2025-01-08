package org.vitalii.fedyk.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.infrastructure.entity.AuthorEntity;

@Mapper(componentModel = "spring")
public interface AuthorEntityMapper {
    AuthorEntity toEntity(Author author);
    Author toModel(AuthorEntity authorEntity);
}
