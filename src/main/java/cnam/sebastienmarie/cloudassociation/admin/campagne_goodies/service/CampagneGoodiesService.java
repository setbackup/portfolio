package cnam.sebastienmarie.cloudassociation.admin.campagne_goodies.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnam.sebastienmarie.cloudassociation.admin.campagne_goodies.dto.CampagneGoodiesCreation;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import cnam.sebastienmarie.cloudassociation.common.campagne.dao.CampagneGoodiesDAO;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneGoodies;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class CampagneGoodiesService {

    @Autowired
    CampagneGoodiesDAO campagneGoodiesDAO;

    public void save(CampagneGoodiesCreation campagneDonCreation, Associations association) throws ParseException {

        SimpleDateFormat date = new SimpleDateFormat("yyyyMMDD");
        String uuid = UUID.randomUUID().toString();
        
        String id_campagneGoodies = "CG".concat(date.format(new Date()))
                                    .concat(uuid.substring(25, 36));

        Date date_debut = date.parse(campagneDonCreation.getDate_debut());
        Date date_fin = date.parse(campagneDonCreation.getDate_fin());

        CampagneGoodies c = new CampagneGoodies(id_campagneGoodies.toUpperCase(),
                                                    campagneDonCreation.getNom(),
                                                    date_debut,
                                                    date_fin,
                                                    campagneDonCreation.getPrix(),
                                                    campagneDonCreation.getQuantite(),
                                                    association);
        
        campagneGoodiesDAO.save(c);
    }

    public List<CampagneGoodies> findAllByAssociation(Associations association){
        List<CampagneGoodies> lstCampagneGoodies =  campagneGoodiesDAO.findByAssociation(association);
        return lstCampagneGoodies;
    }

}
