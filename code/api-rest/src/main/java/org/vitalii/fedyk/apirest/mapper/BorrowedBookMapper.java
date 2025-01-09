package org.vitalii.fedyk.apirest.mapper;

import org.mapstruct.Mapper;
import org.vitalii.fedyk.apirest.dto.CreateBorrowedBookDto;
import org.vitalii.fedyk.apirest.dto.ReadBorrowedBookDto;
import org.vitalii.fedyk.domain.model.BorrowedBook;

@Mapper(componentModel = "spring")
public interface BorrowedBookMapper {
    BorrowedBook toBorrowedBook(CreateBorrowedBookDto createBorrowedBookDto);
    ReadBorrowedBookDto toReadBorrowedBookDto(BorrowedBook borrowedBook);
}
