package org.vitalii.fedyk.infrastructure.hibernate.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;

@Entity
@Table(name = "borrowed_books")
public class BorrowedBookEntity {
    @EmbeddedId
    private BorrowedBookId borrowedBookId;
    private ZonedDateTime borrowDate;
    private ZonedDateTime returnDate;
}