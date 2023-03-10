package com.bookstore.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private long id;
    private String title;
    private String author;
    private double price;

}
