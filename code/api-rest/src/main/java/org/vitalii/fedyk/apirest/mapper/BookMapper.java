package org.vitalii.fedyk.apirest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vitalii.fedyk.apirest.dto.CreateBookDto;
import org.vitalii.fedyk.apirest.dto.ReadBookDto;
import org.vitalii.fedyk.domain.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "author.id", source = "authorId")
    Book toBook(CreateBookDto createBookDto);
    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "authorFullName", source = "author.fullName")
    ReadBookDto toReadBookDto(Book book);
}