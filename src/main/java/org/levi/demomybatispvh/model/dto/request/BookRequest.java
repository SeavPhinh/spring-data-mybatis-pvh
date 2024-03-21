package org.levi.demomybatispvh.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.levi.demomybatispvh.model.Author;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private LocalDateTime publishedDate;
    private Integer authorId;
    private List<Integer> categoryId;
}
