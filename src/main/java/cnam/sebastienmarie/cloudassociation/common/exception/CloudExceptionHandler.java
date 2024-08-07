package cnam.sebastienmarie.cloudassociation.common.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CloudExceptionHandler {

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<String> JsonException(HttpServletRequest req, JsonParseException ex){

        System.out.println("ROO : "+ex.getMessage());
        return ResponseEntity.status(409).body("Erreur");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> SqlError(HttpServletRequest req, DataIntegrityViolationException ex){
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Utilisateur existe déjà");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
  }
}
