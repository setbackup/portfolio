package cnam.sebastienmarie.cloudassociation.common.association.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;

public interface AssociationDAO extends JpaRepository<Associations, String>{
    
}
