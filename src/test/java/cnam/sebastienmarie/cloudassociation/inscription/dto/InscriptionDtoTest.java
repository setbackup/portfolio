package cnam.sebastienmarie.cloudassociation.inscription.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles("test")
@Transactional
public class InscriptionDtoTest {
    
    @Test
    public void testDataUser() throws JsonMappingException, JsonProcessingException{
        String JSON = """
                {
                    nom :"marie",
                    prenom:"sebastien",
                    email :"sebastien@gmail.com",
                    password : "12345",
                    nom_association : "amnesty",
                    adresse_association : "12 rue de la voie",
                    codePostal_association : "92000",
                    ville_association : "paris"
                }
                """;
        ObjectMapper mapper = new ObjectMapper()
                    .enable(SerializationFeature.INDENT_OUTPUT);
        
            InscriptionRequest inscription = mapper.readValue(JSON, InscriptionRequest.class);
           
            assertNotNull(inscription);
    	    assertEquals("marie", inscription.getNom());
     	    assertEquals("sebastien", inscription.getPrenom());
     	    assertEquals("sebastien@gmail.com", inscription.getEmail());
     	    assertEquals("12345", inscription.getPassword());
            assertEquals("amnesty", inscription.getNom_association());
            assertEquals("12 rue de la voie", inscription.getAdresse_association());
            assertEquals("92000", inscription.getCodePostal_association());
            assertEquals("paris", inscription.getVille_association());   
    }

    @Test
    public void testDataWithoutName() throws JsonMappingException, JsonProcessingException{
        String JSON = """
            {
                nom :,
                prenom:"sebastien",
                email :"sebastien@gmail.com",
                password : "12345",
                nom_association : "amnesty",
                adresse_association : "12 rue de la voie",
                codePostal_association : "92000",
                ville_association : "paris"
            }
            """;
    ObjectMapper mapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT);
    
        InscriptionRequest inscription = mapper.readValue(JSON, InscriptionRequest.class);
        assertNotNull(inscription);
        assertEquals("marie", inscription.getNom());
         assertEquals("sebastien", inscription.getPrenom());
         assertEquals("sebastien@gmail.com", inscription.getEmail());
         assertEquals("12345", inscription.getPassword());
        assertEquals("amnesty", inscription.getNom_association());
        assertEquals("12 rue de la voie", inscription.getAdresse_association());
        assertEquals("92000", inscription.getCodePostal_association());
        assertEquals("paris", inscription.getVille_association());
        
    }
}
