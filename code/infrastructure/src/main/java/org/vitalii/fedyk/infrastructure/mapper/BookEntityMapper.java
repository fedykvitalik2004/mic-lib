package org.vitalii.fedyk.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vitalii.fedyk.domain.model.Book;
import org.vitalii.fedyk.infrastructure.entity.BookEntity;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {
    @Mapping(target = "genre", source = "bookGenre")
    @Mapping(target = "author.id", source = "authorId")
    BookEntity toBookEntity(Book book);
    @Mapping(target = "bookGenre", source = "genre")
    @Mapping(target = "authorId", source = "author.id")
    Book toBook(BookEntity bookEntity);
}
