package org.vitalii.fedyk.infrastructure.hibernate.entity;

import jakarta.persistence.*;
import org.vitalii.fedyk.domain.vo.BookGenre;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private BookGenre genre;
    private Integer pagesCount;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
