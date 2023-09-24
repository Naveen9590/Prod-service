package com.naveen_productService.productService.Advice;

import com.naveen_productService.productService.Exceptions.NotFoundException;
import com.naveen_productService.productService.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends Exception{
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException e){
        return new ResponseEntity(new ExceptionDto(e.getMessage(), HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
}
