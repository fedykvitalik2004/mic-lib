package org.vitalii.fedyk.infrastructure.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vitalii.fedyk.infrastructure.hibernate.entity.BorrowedBookEntity;
import org.vitalii.fedyk.infrastructure.hibernate.entity.BorrowedBookId;

@Repository
public interface BorrowedBookEntityRepository extends JpaRepository<BorrowedBookEntity, BorrowedBookId> {
}