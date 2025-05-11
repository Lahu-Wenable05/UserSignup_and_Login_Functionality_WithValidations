package com.wenable.UserAuth.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wenable.UserAuth.customException.EmailAlreadyExistException;
import com.wenable.UserAuth.customException.InvalidEmailException;
import com.wenable.UserAuth.customException.InvalidPasswordException;
import com.wenable.UserAuth.customException.UserAlreadyExistException;
import com.wenable.UserAuth.genericResponse.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Object> handleInvalidEmail(InvalidEmailException ex) {
        return new ResponseEntity<>(new ErrorResponse(false, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> handleUserAlreadyExists(UserAlreadyExistException ex) {
        return new ResponseEntity<>(new ErrorResponse(false, ex.getMessage()), HttpStatus.CONFLICT);
    } 

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Object> handleInvalidPassword(InvalidPasswordException ex) {
        return new ResponseEntity<>(new ErrorResponse(false, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }  
   
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Object> handleEmailAlreadyExists(EmailAlreadyExistException ex) {
        return new ResponseEntity<>(new ErrorResponse(false, ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(false, "Something went wrong: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
