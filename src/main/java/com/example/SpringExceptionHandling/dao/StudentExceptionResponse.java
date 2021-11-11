package com.example.SpringExceptionHandling.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExceptionResponse {
    private Date timestamp;
    //private String errorStatus;
    private String errorDesc;
    private String errorMessage;
}
