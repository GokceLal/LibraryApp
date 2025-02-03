package com.example.LibraryApp.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ErrorMessage {

    private final int code;
    private final String message;
    private List<String> fields;
}
