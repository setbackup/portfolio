package cnam.sebastienmarie.cloudassociation.adherent.campagne.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cnam.sebastienmarie.cloudassociation.common.association.dao.AssociationDAO;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import cnam.sebastienmarie.cloudassociation.common.campagne.dao.CampagneDonsDAO;
import cnam.sebastienmarie.cloudassociation.common.campagne.dao.CampagneGoodiesDAO;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.Campagne;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneDons;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneGoodies;
import cnam.sebastienmarie.cloudassociation.common.service.JWTResult;


@RestController
@RequestMapping("/adherent")
@CrossOrigin(origins = {"http://localhost:5173"})
public class CampagnesAssociationController {

    @Autowired
    JWTResult jwtResult;

    @Autowired
    AssociationDAO associationDAO;

    @Autowired
    CampagneDonsDAO campagneDonsDao;

    @Autowired
    CampagneGoodiesDAO campagneGoodiesDao;

    @GetMapping("/campagnes")
    public ResponseEntity<String> GetAllCampagne() throws JsonProcessingException {

            Optional<Associations> association = this.associationDAO.findById(jwtResult.getIdAssociation());
      
            List<CampagneDons> lstCampagneDons = campagneDonsDao.findByAssociation(association);

            List<CampagneGoodies> lstCampagneGoodies = campagneGoodiesDao.findByAssociation(association);

            List<Campagne> lstCampagne = new ArrayList<>();

            for(CampagneDons campagneDon : lstCampagneDons){
                lstCampagne.add(new Campagne("don" ,
                                            campagneDon.getId(), 
                                            campagneDon.getAssociation().getId(),
                                            campagneDon.getNom(),
                                            campagneDon.getAssociation().getNom(),
                                            campagneDon.getDate_debut(),
                                            campagneDon.getDate_fin()));
            }   

            for(CampagneGoodies campagneGoodies : lstCampagneGoodies){
                lstCampagne.add(new Campagne("goodies",
                                            campagneGoodies.getId(), 
                                            campagneGoodies.getAssociation().getId(),
                                            campagneGoodies.getNom(), 
                                            campagneGoodies.getAssociation().getNom(),
                                            campagneGoodies.getDate_debut(),
                                            campagneGoodies.getDate_fin()));
            }

            return ResponseEntity.ok().body(new ObjectMapper()
                                                .writeValueAsString(lstCampagne));
    }

    @GetMapping("/campagnes/{id}")
    public ResponseEntity<String> getCampagne(@PathVariable("id") String id) throws JsonProcessingException {
        
        if(id.substring(0, 2).equals("CD")){
            System.out.println("Campagne Don");
            Optional<CampagneDons> campagneDon =  campagneDonsDao.findById(id);

            return ResponseEntity.ok().body(new ObjectMapper()
                                            .writeValueAsString(campagneDon.get()));
        }
        else if(id.substring(0, 2).equals("CG")){
            System.out.println("Campagne Goodies");
            Optional<CampagneGoodies> campagneGoodies = campagneGoodiesDao.findById(id);

            return ResponseEntity.ok().body(new ObjectMapper()
                                            .writeValueAsString(campagneGoodies.get()));
        }
        else{
            return ResponseEntity.status(HttpStatusCode.valueOf(204)).body("Aucun element");
        }
    }
    
 
    
}
