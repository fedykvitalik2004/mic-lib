package org.vitalii.fedyk.domain.repository;

import org.vitalii.fedyk.domain.model.BorrowedBook;
import org.vitalii.fedyk.domain.vo.BorrowedBookId;

import java.util.List;
import java.util.Optional;

public interface BorrowedBookRepository {
    boolean existsByBorrowedBookIdUserId(long userId);
    boolean existsByBorrowedBookIdBookId(long bookId);
    List<BorrowedBook> findByUserId(long userId);
    BorrowedBook save(BorrowedBook borrowedBook);
    Optional<BorrowedBook> findById(BorrowedBookId borrowedBookId);
    void delete(BorrowedBookId borrowedBookId);
}
