package cnam.sebastienmarie.cloudassociation.adhesion.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnam.sebastienmarie.cloudassociation.common.adhesion.dao.AdhesionDAO;
import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import cnam.sebastienmarie.cloudassociation.common.adhesion.dto.AdhesionDTO;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdhesionService {


    @Autowired
    AdhesionDAO adhesionDAO;

    public void save(AdhesionDTO adhesionDto){

        SimpleDateFormat date = new SimpleDateFormat("yyyyMMDD");
        String uuid = UUID.randomUUID().toString();
        
        String id_adherent = "AD".concat(date.format(new Date()))
                                    .concat(uuid.substring(25, 36));

        Associations association = new Associations(adhesionDto.getId_association());

        Adherent adhesion = new Adherent(id_adherent, 
                                            adhesionDto.getNom(), 
                                            adhesionDto.getPrenom(), 
                                            adhesionDto.getEmail(),
                                            adhesionDto.getPassword(),
                                            adhesionDto.getAdresse(), 
                                            adhesionDto.getVille(), 
                                            adhesionDto.getCode_postal(),
                                            association);

        adhesionDAO.save(adhesion);
    }
}
