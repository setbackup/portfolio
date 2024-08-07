package cnam.sebastienmarie.cloudassociation.common.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

@Component
public class JWTService {
    
    @Autowired
    JWTResult jwtResult;

    private SecretKey secretKey;

    public JWTService(){
        this.secretKey = Jwts.SIG.HS512.key().build();
    }

    public String getJWT(String login, boolean admin,  String id, String id_association ){
        return Jwts.builder()
                .expiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
                .subject(login) 
                .claim("id", id)       
                .claim("admin", admin)
                .claim("association", id_association)
                .signWith(secretKey)
                .compact();
    }

    public void checkAutorisation(String autorisation){
        try{
            JwtParser parser = Jwts.parser().verifyWith(secretKey).build();
            
            Jws<Claims> parsed = parser.parseSignedClaims(autorisation);
            
            String login = parsed.getPayload().getSubject();

            String id =  parsed.getPayload().get("id", String.class);
            
            String id_association = parsed.getPayload().get("association", String.class);
            
            boolean admin = parsed.getPayload().get("admin", Boolean.class);
            
            jwtResult.buildInfo(login, admin, id ,id_association);
            
        } catch (Exception e){
            jwtResult.buildFail();
        }

    }
}
