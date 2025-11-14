package com.senai.Flora.Interface_ui_Controller.Handler;


import com.senai.Flora.Domain.Exceptions.BadCrendentialsException;
import com.senai.Flora.Domain.Exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ProblemDetail buildProblem(HttpStatus status, String title , String detail , String path) {
        ProblemDetail problem = ProblemDetail.forStatus(status);
        problem.setTitle(title);
        problem.setDetail(detail);
        problem.setInstance(URI.create(path));
        return problem;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFound(UserNotFoundException ex , HttpServletRequest request) {
        return buildProblem(
                HttpStatus.UNAUTHORIZED,
                "User not found",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

    @ExceptionHandler(BadCrendentialsException.class)
    public ProblemDetail handleBadCredentials(BadCrendentialsException ex, HttpServletRequest request) {
        return buildProblem(
                HttpStatus.BAD_REQUEST,
                "Invalid Credentials",
                ex.getMessage(),
                request.getRequestURI()
        );
    }

}
