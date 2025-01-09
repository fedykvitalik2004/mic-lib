package org.vitalii.fedyk.apirest.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import org.vitalii.fedyk.apirest.dto.CreateBookDto;
import org.vitalii.fedyk.apirest.dto.ReadBookDto;
import org.vitalii.fedyk.apirest.mapper.BookMapper;
import org.vitalii.fedyk.domain.usecase.book.CreateBookUseCase;
import org.vitalii.fedyk.domain.usecase.book.DeleteBookUseCase;
import org.vitalii.fedyk.domain.usecase.book.ReadBookUseCase;
import org.vitalii.fedyk.domain.usecase.book.UpdateBookUseCase;

import java.util.List;

@RestController
public class BookController implements BooksApi {
    private ReadBookUseCase readBookUseCase;
    private DeleteBookUseCase deleteBookUseCase;
    private CreateBookUseCase createBookUseCase;
    private UpdateBookUseCase updateBookUseCase;
    private BookMapper bookMapper;

    public BookController(ReadBookUseCase readBookUseCase, DeleteBookUseCase deleteBookUseCase, CreateBookUseCase createBookUseCase, UpdateBookUseCase updateBookUseCase, BookMapper bookMapper) {
        this.readBookUseCase = readBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.createBookUseCase = createBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.bookMapper = bookMapper;
    }

    @Override
    public ReadBookDto createBook(CreateBookDto createBookDto) {
        return bookMapper.toReadBookDto(createBookUseCase.execute(bookMapper.toBook(createBookDto)));
    }

    @Override
    public void deleteBook(Long bookId) {
        deleteBookUseCase.execute(bookId);
    }

    @Override
    public ReadBookDto getBookById(Long bookId) {
        return bookMapper.toReadBookDto(readBookUseCase.execute(bookId));
    }

    @Override
    public List<ReadBookDto> search(String query, Pageable pageable) {
        return List.of();
    }

    @Override
    public ReadBookDto updateBook(Long bookId, CreateBookDto createBookDto) {
        return bookMapper.toReadBookDto(updateBookUseCase.execute(bookId, bookMapper.toBook(createBookDto)));
    }
}