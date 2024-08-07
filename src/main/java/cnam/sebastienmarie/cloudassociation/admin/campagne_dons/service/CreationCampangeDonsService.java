
package cnam.sebastienmarie.cloudassociation.admin.campagne_dons.service;

import cnam.sebastienmarie.cloudassociation.admin.campagne_dons.dto.*;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import cnam.sebastienmarie.cloudassociation.common.campagne.dao.CampagneDonsDAO;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneDons;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreationCampangeDonsService {

   
   @Autowired
   CampagneDonsDAO campagneDonsDAO;

   public CreationCampangeDonsService() {
   }

   public void save(CampagneDonsCreation campagneDonsRequest, Associations association) throws ParseException {
      
      SimpleDateFormat date = new SimpleDateFormat("yyyyMMDD");
      String uuid = UUID.randomUUID().toString();
      
      String id_campagneDons = "CD".concat(date.format(new Date()))
                                  .concat(uuid.substring(25, 36));
   
      Date date_debut =  date.parse(campagneDonsRequest.getDate_debut());
      Date date_fin =  date.parse(campagneDonsRequest.getDate_fin());

      CampagneDons c = new CampagneDons(id_campagneDons,
                                          campagneDonsRequest.getNom(),
                                          date_debut, 
                                          date_fin, 
                                          campagneDonsRequest.getObjectif(), 
                                          association);

      this.campagneDonsDAO.save(c);
   }

   public List<CampagneDons> findAllByAssociation(Associations association) {
      List<CampagneDons> lstCampagneDons = this.campagneDonsDAO.findByAssociation(association);
      
      return lstCampagneDons;
   }
}
