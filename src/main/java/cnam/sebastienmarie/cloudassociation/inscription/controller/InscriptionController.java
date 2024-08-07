package cnam.sebastienmarie.cloudassociation.inscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.sebastienmarie.cloudassociation.inscription.dto.InscriptionRequest;
import cnam.sebastienmarie.cloudassociation.inscription.service.InscriptionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {

    @Autowired
    InscriptionService inscriptService;

    @CrossOrigin(origins = "*")
    @PostMapping(consumes = {"application/json"})
    ResponseEntity<String> newInscription(@Valid @RequestBody InscriptionRequest inscripRequest) {
        inscriptService.save(inscripRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"message\" : \"inscription effectue\" }");            
    }
}
