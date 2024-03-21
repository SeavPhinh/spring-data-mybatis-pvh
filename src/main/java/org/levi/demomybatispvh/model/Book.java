package org.levi.demomybatispvh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private Integer id;
    private String title;
    private LocalDateTime publishedDate;
    private Author author;
    private List<String> categories;
}
