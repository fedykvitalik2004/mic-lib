package org.vitalii.fedyk.infrastructure.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class BorrowedBookEntityId implements Serializable {
    private Long bookId;
    private Long userId;
}