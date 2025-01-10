package org.vitalii.fedyk.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.vitalii.fedyk.domain.vo.FullName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
public class Author extends BaseEntity<Long> implements AggregateRoot {
    private FullName fullName;
    private String description;
    private final List<Book> books = new ArrayList<>();

    public Author(FullName fullName, String description) {
        this.fullName = fullName;
        this.description = description;
    }

    public Author update(Author author) {
        Objects.requireNonNull(author, "Author cannot be null");
        this.fullName = author.fullName;
        this.description = author.description;
        return this;
    }

    public void addBook(Book book) {
        Objects.requireNonNull(book, "Book cannot be null");
        if (book.getAuthorId() != null && !book.getAuthorId().equals(getId())) {
            throw new IllegalArgumentException("Book belongs to another author");
        }
        if (this.books.contains(book)) {
            return;
        }
        book.setAuthorId(getId());
        books.add(book);
    }
}