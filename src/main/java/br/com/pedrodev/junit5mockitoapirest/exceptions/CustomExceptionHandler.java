package br.com.pedrodev.junit5mockitoapirest.exceptions;

import br.com.pedrodev.junit5mockitoapirest.dtos.DefaultError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(NoSuchElementException.class)
   public ResponseEntity handlerExceptionDelete(Exception e){

        DefaultError defaultError = new DefaultError(HttpStatus.BAD_GATEWAY.value(), "no elements found with this ID", LocalDateTime.now());
        return  new ResponseEntity(defaultError,HttpStatus.BAD_GATEWAY);

  }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handlerExceptionCreate(Exception e){

        DefaultError defaultError = new DefaultError(HttpStatus.BAD_GATEWAY.value(), "This email is already registered with the bank!", LocalDateTime.now());
        return  new ResponseEntity(defaultError,HttpStatus.BAD_GATEWAY);

    }
}
