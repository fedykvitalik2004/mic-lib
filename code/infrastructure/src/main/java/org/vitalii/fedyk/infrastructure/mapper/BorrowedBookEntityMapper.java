package org.vitalii.fedyk.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.vitalii.fedyk.domain.model.BorrowedBook;
import org.vitalii.fedyk.infrastructure.entity.BorrowedBookEntity;

@Mapper(componentModel = "spring")
public interface BorrowedBookEntityMapper {
    BorrowedBook toBorrowedBook(BorrowedBookEntity borrowedBookEntity);
    BorrowedBookEntity toBorrowedBookEntity(BorrowedBook borrowedBook);
}