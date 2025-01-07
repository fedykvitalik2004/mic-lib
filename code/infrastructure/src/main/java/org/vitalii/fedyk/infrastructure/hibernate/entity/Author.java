package org.vitalii.fedyk.infrastructure.hibernate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
