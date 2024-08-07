package cnam.sebastienmarie.cloudassociation.common.campagne.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneGoodies;

public interface CampagneGoodiesDAO extends JpaRepository<CampagneGoodies, String> {

    public List<CampagneGoodies> findByAssociation(Associations association);

    public List<CampagneGoodies> findByAssociation(Optional<Associations> association);
    
}
