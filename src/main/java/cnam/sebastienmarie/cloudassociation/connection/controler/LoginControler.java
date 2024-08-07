package cnam.sebastienmarie.cloudassociation.connection.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cnam.sebastienmarie.cloudassociation.connection.dto.LoginRequest;
import cnam.sebastienmarie.cloudassociation.inscription.dao.UsersDAO;
import cnam.sebastienmarie.cloudassociation.inscription.domain.Users;
import cnam.sebastienmarie.cloudassociation.common.adhesion.dao.AdhesionDAO;
import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import cnam.sebastienmarie.cloudassociation.common.service.JWTService;

@RestController
@RequestMapping("/login")
public class LoginControler {

    @Autowired
    private UsersDAO usersDao;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AdhesionDAO adhesionDao;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<String> newInscription(@RequestBody LoginRequest loginRequest) throws JsonProcessingException {

       Users u = usersDao.findByEmail(loginRequest.getEmail().toLowerCase());
       if(u != null){
            if(u.getPassword().equals(loginRequest.getPassdword())){

                ObjectMapper JsonReponse = new ObjectMapper();
                ObjectNode JsonNode = JsonReponse.createObjectNode();
                JsonNode.put("admin", true);
                JsonNode.put("jeton", jwtService.getJWT(loginRequest.getEmail(), 
                                                true, 
                                                    u.getId(),
                                                    u.getAssociation().getId()));

                return ResponseEntity.status(HttpStatus.ACCEPTED).body(JsonReponse.writeValueAsString(JsonNode));
            }
            else{
                return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body("{ \"code\" : \"203\", \"message\" : \"email ou mot de passe incorrect\" }");
            }
       }

       Adherent a = adhesionDao.findByEmail(loginRequest.getEmail().toLowerCase());
       if(a != null){
            if(a.getPassword().equals(loginRequest.getPassdword())){

                ObjectMapper JsonReponse = new ObjectMapper();
                ObjectNode JsonNode = JsonReponse.createObjectNode();
                JsonNode.put("admin", false);
                JsonNode.put("jeton", jwtService.getJWT(loginRequest.getEmail(), 
                                                    false, 
                                                    a.getId(),
                                                    a.getAssociations().getId()));
               


                return ResponseEntity.status(HttpStatus.ACCEPTED).body(JsonReponse.writeValueAsString(JsonNode));
            }
            else{
                return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body("{ \"code\" : \"203\", \"message\" : \"email ou mot de passe incorrect\" }");
            }
       }

       return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body("{ \"code\" : \"203\", \"message\" : \"email ou mot de passe incorrect\" }");

    }
    
}
