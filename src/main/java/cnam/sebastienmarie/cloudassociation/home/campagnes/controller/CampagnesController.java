package cnam.sebastienmarie.cloudassociation.home.campagnes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cnam.sebastienmarie.cloudassociation.common.campagne.domain.Campagne;
import cnam.sebastienmarie.cloudassociation.home.campagnes.service.CampagneService;


@RestController
@RequestMapping("/campagnes")
@CrossOrigin(origins = {"http://localhost:5173"})
public class CampagnesController {

    @Autowired
    CampagneService campagneService;

    @GetMapping
    public ResponseEntity<String> GetAllCampagne() throws JsonProcessingException{

        List<Campagne> lstCampagne = campagneService.findAll();
        
        ObjectMapper JsonCampagnesMapper = new ObjectMapper();

        ArrayNode jsonCampagnes = JsonCampagnesMapper.createArrayNode();

        for (Campagne campagne : lstCampagne){
            ObjectNode jsonCampagne = JsonCampagnesMapper.createObjectNode();
            jsonCampagne.put("id", campagne.getId());
            jsonCampagne.put("id_association", campagne.getId_association());
            jsonCampagne.put("nom", campagne.getNom());
            jsonCampagne.put("date_debut", campagne.getDate_debut().toString());
            jsonCampagne.put("date_fin", campagne.getDate_fin().toString());
            jsonCampagnes.add(jsonCampagne);
        }

        return ResponseEntity.ok().body(JsonCampagnesMapper.writeValueAsString(jsonCampagnes));
    }
    
}
