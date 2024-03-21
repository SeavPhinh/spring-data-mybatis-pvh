package org.levi.demomybatispvh.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorRequest {
    private String authorName;
    private String gender;
}
