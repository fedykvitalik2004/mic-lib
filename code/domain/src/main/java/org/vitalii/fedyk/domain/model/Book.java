package org.vitalii.fedyk.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.vitalii.fedyk.domain.vo.BookGenre;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book extends BaseEntity<Long> {
    private Long authorId;
    private String title;
    private String description;
    private BookGenre bookGenre;
    private Integer pagesCount;
    private List<BorrowedBook> borrowedBooks = new ArrayList<>();

    public Book(Long id, Long authorId, int pagesCount, BookGenre bookGenre, String description, String title) {
        this.id = id;
        this.authorId = authorId;
        this.pagesCount = pagesCount;
        this.bookGenre = bookGenre;
        this.description = description;
        this.title = title;
    }

    public void updateBook(String title, String description, BookGenre bookGenre, int pagesCount, Long authorId) {
        this.title = title;
        this.description = description;
        this.bookGenre = bookGenre;
        this.pagesCount = pagesCount;
        this.authorId = authorId;
    }

    public void addBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBooks.add(borrowedBook);
    }
}