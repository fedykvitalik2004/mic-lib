package org.vitalii.fedyk.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.vitalii.fedyk.domain.vo.BookGenre;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book extends BaseEntity<Long> {
    private Author author;
    private String title;
    private String description;
    private BookGenre bookGenre;
    private Integer pagesCount;

    public Book(Long bookId, Author author, int pagesCount, BookGenre bookGenre, String description, String title) {
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

    public void updateBook(String title, String description, BookGenre bookGenre, int pagesCount, Author author) {
        validateTitle(title);
        this.title = title;
        this.description = description;
        this.bookGenre = bookGenre;
        this.pagesCount = pagesCount;
        this.author = author;
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