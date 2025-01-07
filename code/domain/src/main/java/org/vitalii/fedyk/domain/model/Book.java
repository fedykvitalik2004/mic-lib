package org.vitalii.fedyk.domain.model;

import org.vitalii.fedyk.domain.vo.BookGenre;
import org.vitalii.fedyk.domain.vo.BookId;

public class Book extends BaseEntity<BookId> {
    private final Author author;
    private String title;
    private String description;
    private final BookGenre bookGenre;
    private final Integer pagesCount;

    public Book(BookId bookId, Author author, int pagesCount, BookGenre bookGenre, String description, String title) {
        validateAuthor(author);
        validateTitle(title);
        validateBookGenre(bookGenre);
        validatePagesCount(pagesCount);
        super.setId(bookId);
        this.author = author;
        this.pagesCount = pagesCount;
        this.bookGenre = bookGenre;
        this.description = description;
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    void validateAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author: Firstname Lastname be null");
        }
    }

    void updateBook(String title, String description) {
        validateTitle(title);
        this.title = title;
        this.description = description;
    }

    void validatePagesCount(Integer pagesCount) {
        if (pagesCount == null || pagesCount <= 0) {
            throw new IllegalArgumentException("Pages count cannot be negative");
        }
    }

    void validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }

    void validateBookGenre(BookGenre bookGenre) {
        if (bookGenre == null) {
            throw new IllegalArgumentException("Book genre cannot be null");
        }
    }
}