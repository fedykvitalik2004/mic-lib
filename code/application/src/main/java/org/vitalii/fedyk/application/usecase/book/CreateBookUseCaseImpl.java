package org.vitalii.fedyk.application.usecase.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.model.Book;
import org.vitalii.fedyk.domain.repository.BookRepository;
import org.vitalii.fedyk.domain.usecase.author.ReadAuthorUseCase;
import org.vitalii.fedyk.domain.usecase.book.CreateBookUseCase;

@Component
@AllArgsConstructor
public class CreateBookUseCaseImpl implements CreateBookUseCase {
    private ReadAuthorUseCase readAuthorUseCase;
    private BookRepository bookRepository;

    @Override
    public Book execute(Book book) {
        book.setAuthor(readAuthorUseCase.execute(book.getAuthor().getId()));
        return bookRepository.save(book);
    }
}
