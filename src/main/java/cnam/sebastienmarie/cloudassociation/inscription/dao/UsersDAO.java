package cnam.sebastienmarie.cloudassociation.inscription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.sebastienmarie.cloudassociation.inscription.domain.Users;

public interface UsersDAO extends JpaRepository<Users, String>{

    public Users findByEmail(String email);
    
}
