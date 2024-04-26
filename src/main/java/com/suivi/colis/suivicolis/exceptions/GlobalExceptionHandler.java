/*
 * **
 *  * @project : SuiviColis
 *  * @created : 26/04/2024, 15:51
 *  * @modified : 25/04/2024, 19:05
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

/*
 * **
 *  * @project : SuiviColis
 *  * @created : 25/04/2024, 17:22
 *  * @modified : 25/04/2024, 17:22
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.View;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
            .getAllErrors().stream()
            .map(ObjectError::getDefaultMessage)
            .collect(Collectors.toList());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }




    @ExceptionHandler(IllegalUserAttributesException.class)
    public ResponseEntity<Error> handleInvalidUserAttributesException(IllegalUserAttributesException ex, HttpServletRequest request) {
        Error error = new Error(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date(), request.getRequestURI());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<List<String>> handleRuntimeException(RuntimeException ex) {
//        List<String> errors = List.of(ex.getMessage());
//
//        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR );
//    }

}
