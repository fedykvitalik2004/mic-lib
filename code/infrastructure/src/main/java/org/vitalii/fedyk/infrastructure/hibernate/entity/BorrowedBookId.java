package org.vitalii.fedyk.infrastructure.hibernate.entity;

import java.io.Serializable;

public class BorrowedBookId implements Serializable {
    private Long bookId;
    private Long userId;
}