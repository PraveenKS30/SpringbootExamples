package com.example.SpringExceptionHandling.exception;

import com.example.SpringExceptionHandling.dao.StudentExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class StudentGenericException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        StudentExceptionResponse studentExceptionResponse =
                new StudentExceptionResponse(new Date(), request.getDescription(false), ex.getMessage());

        return new ResponseEntity<>(studentExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity<Object> handleStudentNotFoundException(Exception ex, WebRequest request) throws Exception {
        StudentExceptionResponse studentExceptionResponse =
                new StudentExceptionResponse(new Date(), request.getDescription(false), ex.getMessage());

        return new ResponseEntity<>(studentExceptionResponse, HttpStatus.NOT_FOUND);

    }


}
