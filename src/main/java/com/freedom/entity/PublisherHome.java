package com.freedom.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PublisherHome extends BaseEntity {

    private String name;

    @Column(length = 5000)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publisherHome")
      private List<Book> books;

}
