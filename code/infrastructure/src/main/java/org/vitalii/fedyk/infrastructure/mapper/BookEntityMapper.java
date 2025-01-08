package org.vitalii.fedyk.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.vitalii.fedyk.domain.model.Book;
import org.vitalii.fedyk.infrastructure.entity.BookEntity;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {
    BookEntity toBookEntity(Book book);
    Book toBook(BookEntity bookEntity);
}
