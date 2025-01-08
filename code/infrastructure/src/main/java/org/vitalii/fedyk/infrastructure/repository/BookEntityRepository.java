package org.vitalii.fedyk.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vitalii.fedyk.infrastructure.entity.BookEntity;

import java.util.List;

@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT be " +
           "FROM BookEntity be " +
           "JOIN FETCH be.author " +
           "WHERE be.id IN :ids")
    List<BookEntity> findAllByIds(List<Long> ids);

    boolean existsByAuthorId(Long authorId);

    long countByTitle(String title);
}