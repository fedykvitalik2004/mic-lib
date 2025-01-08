package org.vitalii.fedyk.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vitalii.fedyk.infrastructure.entity.AuthorEntity;

@Repository
public interface AuthorEntityRepository extends JpaRepository<AuthorEntity, Long> {
}