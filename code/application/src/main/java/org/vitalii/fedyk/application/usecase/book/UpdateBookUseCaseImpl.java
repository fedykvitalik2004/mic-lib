package org.vitalii.fedyk.application.usecase.book;

import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.exception.NotFoundException;
import org.vitalii.fedyk.domain.model.Author;
import org.vitalii.fedyk.domain.model.Book;
import org.vitalii.fedyk.domain.repository.BookRepository;
import org.vitalii.fedyk.domain.usecase.author.ReadAuthorUseCase;
import org.vitalii.fedyk.domain.usecase.book.UpdateBookUseCase;

import static org.vitalii.fedyk.infrastructure.constant.ExceptionConstants.BOOK_NOT_FOUND_BY_ID;

@Component
public class UpdateBookUseCaseImpl implements UpdateBookUseCase {
    private BookRepository bookRepository;
    private ReadAuthorUseCase readAuthorUseCase;

    @Override
    public Book execute(long bookId, Book book) {
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BOOK_NOT_FOUND_BY_ID.formatted(bookId)));
        Author author = readAuthorUseCase.execute(book.getAuthor().getId());
        existingBook.updateBook(book.getTitle(), book.getDescription(), book.getBookGenre(), book.getPagesCount(), author);
        return bookRepository.save(existingBook);
    }
}
