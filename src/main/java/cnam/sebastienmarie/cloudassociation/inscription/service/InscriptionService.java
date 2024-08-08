package cnam.sebastienmarie.cloudassociation.inscription.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cnam.sebastienmarie.cloudassociation.common.association.dao.AssociationDAO;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import cnam.sebastienmarie.cloudassociation.inscription.dao.UsersDAO;
import cnam.sebastienmarie.cloudassociation.inscription.domain.Users;
import cnam.sebastienmarie.cloudassociation.inscription.dto.InscriptionRequest;

@Service
@Transactional
public class InscriptionService {

    @Autowired
    UsersDAO usersDao;

    @Autowired
    AssociationDAO associationDao;
    
    public void save(InscriptionRequest insRequest) {
       
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMDD");
        String uuid = UUID.randomUUID().toString();
        
        String id_association = "A".concat(date.format(new Date()))
                                    .concat(uuid.substring(25, 36));

        String id_users = "U".concat(date.format(new Date()))
                                .concat(UUID.randomUUID()
                                .toString()
                                .substring(25, 36));
    
        Associations a = new Associations(id_association.toUpperCase(), 
                                            insRequest.getAssociationDto().getNom().toLowerCase(), 
                                            insRequest.getAssociationDto().getAdresse().toLowerCase(), 
                                            insRequest.getAssociationDto().getCodePostal().toLowerCase(),
                                            insRequest.getAssociationDto().getVille().toLowerCase());

        Users u = new Users(id_users.toUpperCase(), 
                            insRequest.getNom().toLowerCase(), 
                            insRequest.getPrenom().toLowerCase(), 
                            insRequest.getEmail().toLowerCase(), 
                            insRequest.getPassword(),
                            a) ;
      
            associationDao.save(a);
            usersDao.save(u);
    }

}
