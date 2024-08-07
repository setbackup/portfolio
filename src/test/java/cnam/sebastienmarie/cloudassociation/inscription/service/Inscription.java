package cnam.sebastienmarie.cloudassociation.inscription.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import cnam.sebastienmarie.cloudassociation.inscription.dto.InscriptionRequest;

import jakarta.transaction.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles("test")
@Transactional
public class Inscription {

    @Autowired
    InscriptionService inscriptionService;

    @Test
    public void testInscriptionExist() throws Exception {
        InscriptionRequest i = new InscriptionRequest("marie",
                                                    "sebastien",
                                                    "sebastien.marie07@gmail.com",
                                                    "12345",
                                                    "heel",
                                                    "12 rue de gaule",
                                                    "59800",
                                                    "lille");
        inscriptionService.save(i);

    }

}
