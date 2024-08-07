package cnam.sebastienmarie.cloudassociation.common.adhesion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;

public interface AdhesionDAO extends JpaRepository<Adherent, String>{

    Adherent findByEmail(String email);
    
}
