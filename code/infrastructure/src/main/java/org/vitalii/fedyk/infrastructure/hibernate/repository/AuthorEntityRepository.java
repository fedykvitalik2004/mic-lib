package org.vitalii.fedyk.infrastructure.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vitalii.fedyk.domain.model.Author;

@Repository
public interface AuthorEntityRepository extends JpaRepository<Author, Long> {
}