package cnam.sebastienmarie.cloudassociation.common.campagne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.sebastienmarie.cloudassociation.common.campagne.domain.Donnation;

public interface DonsDAO  extends JpaRepository<Donnation, String> {
    
}
