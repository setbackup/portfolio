package cnam.sebastienmarie.cloudassociation.adherent.goodies.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.sebastienmarie.cloudassociation.adherent.goodies.dto.GoodiesDTO;
import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import cnam.sebastienmarie.cloudassociation.common.campagne.dao.GoodiesDAO;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneGoodies;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.Goodies;
import cnam.sebastienmarie.cloudassociation.common.service.JWTResult;

@RestController
@CrossOrigin(
   origins = {"http://localhost:5173"}
)
@RequestMapping("/goodies")
public class GoodiesController {

   @Autowired
   JWTResult jwtResult;

   @Autowired
   GoodiesDAO goodiesDao;

   @PostMapping
   public ResponseEntity<String> goodies(@RequestBody GoodiesDTO goodiesDto){

      System.out.println(goodiesDto.getQuantite());

      Adherent adherent = new Adherent(jwtResult.getId());
      CampagneGoodies campagneGoodies = new CampagneGoodies(goodiesDto.getId_campagne());

      SimpleDateFormat date = new SimpleDateFormat("yyyyMMDD");
      String uuid = UUID.randomUUID().toString();
        
      String id_goodie = "GOODIES".concat(date.format(new Date()))
                                    .concat(uuid.substring(25, 36));

      Goodies goodie = new Goodies(id_goodie, goodiesDto.getQuantite(), adherent, campagneGoodies);   

      goodiesDao.save(goodie);
      
      return ResponseEntity.ok().body("TODO");
   }
    
}
