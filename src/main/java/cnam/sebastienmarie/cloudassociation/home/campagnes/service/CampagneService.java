package cnam.sebastienmarie.cloudassociation.home.campagnes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnam.sebastienmarie.cloudassociation.common.campagne.dao.CampagneDonsDAO;
import cnam.sebastienmarie.cloudassociation.common.campagne.dao.CampagneGoodiesDAO;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.Campagne;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneDons;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneGoodies;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CampagneService {

    @Autowired
    CampagneDonsDAO campagneDonsDao;

    @Autowired
    CampagneGoodiesDAO campagneGoodiesDao;    

    public List<Campagne> findAll() {

        List<CampagneDons> lstCampagneDons = campagneDonsDao.findAll();

        List<CampagneGoodies> lstCampagneGoodies = campagneGoodiesDao.findAll();

        List<Campagne> lstCampagne = new ArrayList<>();

        for(CampagneDons campagneDon : lstCampagneDons){
            lstCampagne.add(new Campagne( "don",
                                            campagneDon.getId(), 
                                            campagneDon.getAssociation().getId(),
                                            campagneDon.getNom(),
                                            campagneDon.getAssociation().getNom(),
                                            campagneDon.getDate_debut(),
                                            campagneDon.getDate_fin()));
        }

        for(CampagneGoodies campagneGoodies : lstCampagneGoodies){
            lstCampagne.add(new Campagne( "goodies",
                                            campagneGoodies.getId(), 
                                            campagneGoodies.getAssociation().getId(),
                                            campagneGoodies.getNom(), 
                                            campagneGoodies.getAssociation().getNom(),
                                            campagneGoodies.getDate_debut(),
                                            campagneGoodies.getDate_fin()));
        }

        return lstCampagne;

    }
    
}
