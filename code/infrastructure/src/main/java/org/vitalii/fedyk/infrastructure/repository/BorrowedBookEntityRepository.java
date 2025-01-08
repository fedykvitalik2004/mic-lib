package org.vitalii.fedyk.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vitalii.fedyk.infrastructure.entity.BorrowedBookEntity;
import org.vitalii.fedyk.infrastructure.entity.BorrowedBookEntityId;

import java.util.List;

@Repository
public interface BorrowedBookEntityRepository extends JpaRepository<BorrowedBookEntity, BorrowedBookEntityId> {
    boolean existsByBorrowedBookIdUserId(long userId);

    boolean existsByBorrowedBookIdBookId(long bookId);

    @Query("SELECT bbe " +
           "FROM BorrowedBookEntity bbe " +
           "JOIN FETCH BookEntity be ON bbe.borrowedBookId.bookId = be.id " +
           "WHERE bbe.borrowedBookId.userId = :userId")
    List<BorrowedBookEntity> findByUserId(long userId);
}