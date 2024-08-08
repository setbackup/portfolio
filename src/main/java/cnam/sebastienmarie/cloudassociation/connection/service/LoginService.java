package cnam.sebastienmarie.cloudassociation.connection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnam.sebastienmarie.cloudassociation.connection.dto.LoginRequest;
import cnam.sebastienmarie.cloudassociation.inscription.dao.UsersDAO;

@Service
public class LoginService {

    @Autowired
    private UsersDAO usersDao;

    public void findByEmail(LoginRequest loginRequest) {
       
        usersDao.findByEmail(loginRequest.getEmail());
    }

}
