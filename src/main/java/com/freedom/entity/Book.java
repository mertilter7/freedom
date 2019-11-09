package com.freedom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book extends BaseEntity {

    private String name;

    private String subTitle;

    private String bookSerialName;

    private String authorName;

    private String publishHome;

    private Long isbn;

    @Column(length = 5000)
    private String description;

    @ManyToOne()
    private PublisherHome publisherHome;

    @ManyToOne()
    private Author author;

}
