package org.vitalii.fedyk.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.vitalii.fedyk.domain.vo.FullName;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Author extends BaseEntity<Long> {
    private FullName fullName;
    private String description;
    private List<Book> books;
}