package org.vitalii.fedyk.infrastructure.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vitalii.fedyk.infrastructure.hibernate.entity.Book;

@Repository
public interface BookEntityRepository extends JpaRepository<Book, Long> {
}
