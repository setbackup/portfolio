package cnam.sebastienmarie.cloudassociation.admin.adhesion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cnam.sebastienmarie.cloudassociation.common.adhesion.dao.AdhesionDAO;
import cnam.sebastienmarie.cloudassociation.common.adhesion.dto.AdhesionDTO;
import jakarta.validation.Valid;

@RestController
public class AdhesionController {

      @Autowired
      AdhesionDAO adhesionDao;

      @PostMapping
      ResponseEntity<?> enregistrerAdhesion(@Valid @RequestBody AdhesionDTO adhesionDto){

        
        return null;

     }
    
}
