package org.vitalii.fedyk.infrastructure.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Entity
@Table(name = "borrowed_books")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class BorrowedBookEntity {
    @EmbeddedId
    private BorrowedBookEntityId borrowedBookId;
    private ZonedDateTime borrowDate;
    private ZonedDateTime returnDate;
}