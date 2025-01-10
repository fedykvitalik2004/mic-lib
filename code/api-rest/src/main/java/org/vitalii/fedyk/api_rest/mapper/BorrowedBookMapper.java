package org.vitalii.fedyk.api_rest.mapper;

import org.mapstruct.Mapper;
import org.vitalii.fedyk.api_rest.generated.dto.ReadBorrowedBookDto;
import org.vitalii.fedyk.domain.model.BorrowedBook;

@Mapper(componentModel = "spring")
public interface BorrowedBookMapper {
    BorrowedBook toBorrowedBook(org.vitalii.fedyk.api_rest.generated.dto.CreateBorrowedBookDto createBorrowedBookDto);
    ReadBorrowedBookDto toReadBorrowedBookDto(BorrowedBook borrowedBook);
}
