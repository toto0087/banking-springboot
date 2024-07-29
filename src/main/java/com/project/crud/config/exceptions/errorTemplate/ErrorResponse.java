package com.project.crud.config.exceptions.errorTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    public ErrorResponse(String message)
    {
        super();
        this.message = message;
    }
}
