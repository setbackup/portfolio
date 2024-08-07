package cnam.sebastienmarie.cloudassociation.adherent.donnation.controller;

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

import cnam.sebastienmarie.cloudassociation.adherent.donnation.dto.DonnationDTO;
import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import cnam.sebastienmarie.cloudassociation.common.campagne.dao.DonsDAO;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneDons;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.Donnation;
import cnam.sebastienmarie.cloudassociation.common.service.JWTResult;

@RestController
@CrossOrigin(
   origins = {"http://localhost:5173"}
)
@RequestMapping("/donnations")
public class DonnationController {

    @Autowired
    JWTResult jwtResult;

    @Autowired
    DonsDAO donsDao;

    @PostMapping
    public ResponseEntity<String> donnation(@RequestBody DonnationDTO donnationDto){

        Adherent adherent = new Adherent(jwtResult.getId());
        CampagneDons campagneDon = new CampagneDons(donnationDto.getId_campagnedon());

        SimpleDateFormat date = new SimpleDateFormat("yyyyMMDD");
        String uuid = UUID.randomUUID().toString();
        
        String id_don = "DON".concat(date.format(new Date()))
                                    .concat(uuid.substring(25, 36));

        Donnation dons = new Donnation(donnationDto.getMontant(), 
                                        id_don.toUpperCase(),
                                        adherent,
                                        campagneDon
                                        ) ;

        donsDao.save(dons);
        
        return ResponseEntity.ok().body("ok");
    }
    
}
