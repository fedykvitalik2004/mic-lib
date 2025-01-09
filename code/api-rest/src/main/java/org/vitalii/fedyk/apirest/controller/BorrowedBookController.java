package org.vitalii.fedyk.apirest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.vitalii.fedyk.apirest.dto.CreateBorrowedBookDto;
import org.vitalii.fedyk.apirest.dto.ReadBorrowedBookDto;
import org.vitalii.fedyk.apirest.mapper.BorrowedBookMapper;
import org.vitalii.fedyk.domain.usecase.borrowedbook.CreateBorrowedBookUseCase;
import org.vitalii.fedyk.domain.usecase.borrowedbook.GetBorrowedBooksByUserIdUseCase;
import org.vitalii.fedyk.domain.usecase.borrowedbook.IsBorrowedByUserUseCase;
import org.vitalii.fedyk.domain.usecase.borrowedbook.RemoveBorrowedBookUseCase;

import java.util.List;

@RestController
public class BorrowedBookController implements BorrowedBooksApi {
    private CreateBorrowedBookUseCase createBorrowedBookUseCase;
    private RemoveBorrowedBookUseCase removeBorrowedBookUseCase;
    private GetBorrowedBooksByUserIdUseCase getBorrowedBooksByUserIdUseCase;
    private IsBorrowedByUserUseCase isBorrowedByUserUseCase;
    private BorrowedBookMapper borrowedBookMapper;

    public BorrowedBookController(CreateBorrowedBookUseCase createBorrowedBookUseCase, RemoveBorrowedBookUseCase removeBorrowedBookUseCase, GetBorrowedBooksByUserIdUseCase getBorrowedBooksByUserIdUseCase, IsBorrowedByUserUseCase isBorrowedByUserUseCase, BorrowedBookMapper borrowedBookMapper) {
        this.createBorrowedBookUseCase = createBorrowedBookUseCase;
        this.removeBorrowedBookUseCase = removeBorrowedBookUseCase;
        this.getBorrowedBooksByUserIdUseCase = getBorrowedBooksByUserIdUseCase;
        this.isBorrowedByUserUseCase = isBorrowedByUserUseCase;
        this.borrowedBookMapper = borrowedBookMapper;
    }

    @Override
    public ReadBorrowedBookDto addBorrowedBook(CreateBorrowedBookDto createBorrowedBookDto) {
        return borrowedBookMapper.toReadBorrowedBookDto(createBorrowedBookUseCase.execute(
                borrowedBookMapper.toBorrowedBook(createBorrowedBookDto))
        );
    }

    @Override
    public void deleteBorrowedBook(Long bookId, Long userId) {
        removeBorrowedBookUseCase.execute(bookId, userId);
    }

    @Override
    public List<ReadBorrowedBookDto> findBorrowedBooks(Long userId) {
        return getBorrowedBooksByUserIdUseCase.execute(userId).stream()
                .map(o -> borrowedBookMapper.toReadBorrowedBookDto(o))
                .toList();
    }

    @Override
    public Boolean isBorrowedByUser(Long userId) {
        return isBorrowedByUserUseCase.execute(userId);
    }
}
