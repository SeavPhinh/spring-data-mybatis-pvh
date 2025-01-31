package org.levi.demomybatispvh.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse<T> {

    private String message;
    private HttpStatus status;
    private Integer code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;
}
