package cnam.sebastienmarie.cloudassociation.adhesion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cnam.sebastienmarie.cloudassociation.adhesion.service.AdhesionService;
import cnam.sebastienmarie.cloudassociation.common.adhesion.dto.AdhesionDTO;
import cnam.sebastienmarie.cloudassociation.common.association.dao.AssociationDAO;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin(
   origins = {"http://localhost:5173"}
)
@RequestMapping({"/adhesion"})
public class AdhesionController {
    
    @Autowired
    AdhesionService adhesionService;

    @Autowired
    AssociationDAO associationDAO;

    @PostMapping
    public ResponseEntity<String> Adhesion(@Valid @RequestBody AdhesionDTO adhesionDTO) {
        
        adhesionService.save(adhesionDTO);
        
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping
    public ResponseEntity<String> GetAllAssociation() throws JsonProcessingException {

        List<Associations> lstAssociation = associationDAO.findAll();

        ObjectMapper JsonAssociationsMapper = new ObjectMapper();

        ArrayNode JsonAssociations = JsonAssociationsMapper.createArrayNode();

        for (Associations association : lstAssociation) {
            ObjectNode jsonAssociation = JsonAssociationsMapper.createObjectNode();
            jsonAssociation.put("id", association.getId());
            jsonAssociation.put("nom", association.getNom());
            JsonAssociations.add(jsonAssociation);
        }

        return ResponseEntity.ok().body(JsonAssociationsMapper.writeValueAsString(JsonAssociations));
    }
}
