package org.vitalii.fedyk.domain.model;

import org.vitalii.fedyk.domain.vo.AuthorId;
import org.vitalii.fedyk.domain.vo.FullName;

import java.util.List;

public class Author extends BaseEntity<AuthorId> {
    private FullName fullName;
    private String description;
    private List<Book> books;
}