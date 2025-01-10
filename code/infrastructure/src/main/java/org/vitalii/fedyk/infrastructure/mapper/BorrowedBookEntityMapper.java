package org.vitalii.fedyk.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vitalii.fedyk.domain.model.BorrowedBook;
import org.vitalii.fedyk.infrastructure.entity.BorrowedBookEntity;

@Mapper(componentModel = "spring")
public interface BorrowedBookEntityMapper {
    @Mapping(target = "id.userId", source = "borrowedBookId.userId")
    @Mapping(target = "id.bookId", source = "borrowedBookId.bookId")
    BorrowedBook toBorrowedBook(BorrowedBookEntity borrowedBookEntity);
    @Mapping(target = "borrowedBookId.userId", source = "id.userId")
    @Mapping(target = "borrowedBookId.bookId", source = "id.bookId")
    BorrowedBookEntity toBorrowedBookEntity(BorrowedBook borrowedBook);
}