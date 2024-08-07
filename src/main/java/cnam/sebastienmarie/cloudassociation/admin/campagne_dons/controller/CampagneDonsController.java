package cnam.sebastienmarie.cloudassociation.admin.campagne_dons.controller;


import cnam.sebastienmarie.cloudassociation.admin.campagne_dons.dto.CampagneDonsCreation;
import cnam.sebastienmarie.cloudassociation.admin.campagne_dons.service.CreationCampangeDonsService;
import cnam.sebastienmarie.cloudassociation.common.association.dao.AssociationDAO;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneDons;
import cnam.sebastienmarie.cloudassociation.common.service.JWTResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
   origins = {"http://localhost:5173"}
)
@RequestMapping({"/campagnes_dons"})
public class CampagneDonsController<CeationCampangeDons> {

   @Autowired
   CreationCampangeDonsService creationCampagneDonsService;

   @Autowired
   AssociationDAO associationDAO;
   
   @Autowired
   JWTResult jwtResult;

   @PostMapping(
      value = {"/creation"},
      consumes = {"application/json"}
   )
   ResponseEntity<String> campagne_dons(@RequestBody CampagneDonsCreation campagneDonsRequest, @RequestHeader("Authorization") String Token) throws ParseException {
      
      Associations association = (Associations)this.associationDAO.findById(jwtResult.getIdAssociation()).get();
      this.creationCampagneDonsService.save(campagneDonsRequest, association);
      return ResponseEntity.ok().body("Campagne de dons cr\u00e9er");
   }

   @GetMapping({"/consulter"})
   ResponseEntity<String> campagne_dons(@RequestHeader("Authorization") String Token) throws JsonProcessingException {


      Associations association = (Associations)this.associationDAO.findById(jwtResult.getIdAssociation()).get();
      
      List<CampagneDons> lstCampagneDons = this.creationCampagneDonsService.findAllByAssociation(association);

      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.setDateFormat(df);
      String jsonArray = objectMapper.writeValueAsString(lstCampagneDons);

      System.out.println(jsonArray);


      return ResponseEntity.ok().body(jsonArray);
   }
}
