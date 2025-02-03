package com.example.LibraryApp.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.example.LibraryApp.exception.ErrorType.BAD_REQUEST_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ErrorMessage> globalHandler(RuntimeException runtimeException) {
//        return new ResponseEntity<>(createErrorMessage(runtimeException, ErrorType.INTERNAL_ERROR),
//                HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(LibraryServiceException.class)
//    @ResponseBody
//    public ResponseEntity<ErrorMessage> libraryServiceHandler(LibraryServiceException libraryServiceException) {
//        return new ResponseEntity<>(createErrorMessage(libraryServiceException, libraryServiceException.getErrorType()),
//                libraryServiceException.getErrorType().getHttpStatus());
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseBody
//    public ResponseEntity<ErrorMessage> duplicateKeyHandler(ConstraintViolationException duplicateKeyException) {
//        return new ResponseEntity<>(createErrorMessage(duplicateKeyException, ErrorType.BAD_REQUEST_ERROR),
//                HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public final ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
//            MethodArgumentNotValidException exception) {
//
//        ErrorType errorType = BAD_REQUEST_ERROR;
//        List<String> fields = new ArrayList<>();
//        exception
//                .getBindingResult()
//                .getFieldErrors()
//                .forEach(e -> fields.add(e.getField() + ": " + e.getDefaultMessage()));
//        ErrorMessage errorMessage = createErrorMessage(exception, errorType);
//        errorMessage.setFields(fields);
//        return new ResponseEntity<>(errorMessage, errorType.getHttpStatus());
//    }
//
//    private ErrorMessage createErrorMessage(Exception exception, ErrorType errorType) {
//        System.out.println("Tüm hataların geçtiği nokta...: " + exception.getMessage());
//        return ErrorMessage.builder()
//                .message(errorType.getMessage())
//                .code(errorType.getCode())
//                .build();
//    }
}
