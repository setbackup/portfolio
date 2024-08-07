package cnam.sebastienmarie.cloudassociation.admin.campagne_goodies.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cnam.sebastienmarie.cloudassociation.admin.campagne_goodies.dto.CampagneGoodiesCreation;
import cnam.sebastienmarie.cloudassociation.admin.campagne_goodies.service.CampagneGoodiesService;
import cnam.sebastienmarie.cloudassociation.common.association.dao.AssociationDAO;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneGoodies;
import cnam.sebastienmarie.cloudassociation.common.service.JWTResult;

import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin
@RequestMapping("/campagne_goodies")
public class CampagneGoodiesController {

    @Autowired
    AssociationDAO associationDAO;

    @Autowired
    JWTResult jwtResult;

    @Autowired
    CampagneGoodiesService campagneGoodiesService;

    
    @PostMapping("/creation")
    public ResponseEntity<String> CreerCampagneGoodies(@RequestBody CampagneGoodiesCreation campagneGoodiesRequest) throws ParseException {

        Associations association = associationDAO.findById(jwtResult.getIdAssociation()).get();

        campagneGoodiesService.save(campagneGoodiesRequest, association);

        return ResponseEntity.ok().body("Campagne de vente goodies est créer");
    }

    @GetMapping("/consulter")
    public ResponseEntity<String> ConsulterCampagneDons() throws JsonProcessingException {
        
        Associations association = associationDAO.findById(jwtResult.getIdAssociation()).get();

        List<CampagneGoodies> lstCampagneGoodies = campagneGoodiesService.findAllByAssociation(association);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(df);
        String jsonArray = objectMapper.writeValueAsString(lstCampagneGoodies);
        
        return ResponseEntity.ok().body(jsonArray);
    }

}
