package com.example.school.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@Data
public class DisplayedError {

    private HttpStatus status;
    private int statusNumber;
    private List<String> errors;

    public DisplayedError(HttpStatus status, int statusNumber, String errror) {
        this.status = status;
        this.statusNumber = statusNumber;
        errors = List.of(errror);
    }
}
