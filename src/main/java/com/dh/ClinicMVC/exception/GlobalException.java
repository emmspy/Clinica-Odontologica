package com.dh.ClinicMVC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> recursoNoEncontrado(ResourceNotFoundException e) {
        //vamos a querer que cuando se lance la excepción se devuelva un 404/400
        //y el mensaje
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }



}
