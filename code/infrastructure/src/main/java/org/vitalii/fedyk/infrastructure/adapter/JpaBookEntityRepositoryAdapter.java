package org.vitalii.fedyk.infrastructure.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.model.Book;
import org.vitalii.fedyk.domain.repository.BookRepository;
import org.vitalii.fedyk.infrastructure.entity.AuthorEntity;
import org.vitalii.fedyk.infrastructure.entity.BookEntity;
import org.vitalii.fedyk.infrastructure.mapper.BookEntityMapper;
import org.vitalii.fedyk.infrastructure.repository.AuthorEntityRepository;
import org.vitalii.fedyk.infrastructure.repository.BookEntityRepository;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaBookEntityRepositoryAdapter implements BookRepository {
    private final AuthorEntityRepository authorEntityRepository;
    private BookEntityRepository bookEntityRepository;
    private BookEntityMapper bookEntityMapper;

    @Override
    public List<Book> findAllByIds(List<Long> authorIds) {
        return bookEntityRepository.findAllByIds(authorIds).stream()
                .map(o -> bookEntityMapper.toBook(o))
                .toList();
    }

    @Override
    public boolean existsByAuthorId(Long authorId) {
        return bookEntityRepository.existsByAuthorId(authorId);
    }

    @Override
    public long countByTitle(String title) {
        return bookEntityRepository.countByTitle(title);
    }

    @Override
    public Book save(Book book) {
        AuthorEntity author = authorEntityRepository.findById(book.getAuthorId())
                .orElseThrow();
        BookEntity bookEntity = bookEntityMapper.toBookEntity(book);
        bookEntity.setAuthor(author);
        return bookEntityMapper.toBook(bookEntityRepository.save(bookEntity));
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return bookEntityRepository.findById(bookId)
                .map(o -> {
                    Book book = bookEntityMapper.toBook(o);
                    return bookEntityMapper.toBook(o);
                });
    }

    @Override
    public void delete(long bookId) {
        bookEntityRepository.deleteById(bookId);
    }
}