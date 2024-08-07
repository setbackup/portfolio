package cnam.sebastienmarie.cloudassociation.inscription.domain;

import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    private String id = "";

    private String nom="";
    
    private String prenom="";

    @Column(unique=true)
    private String email="";

    private String password="";

    @OneToOne 
    @JoinColumn(name="id_association")
    private Associations association;

    protected Users(){

    }

    public Users(String id, 
                    String nom,
                    String prenom,
                    String email,
                    String password,
                    Associations association) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.association = association;
    }

    public Users(String id,
                    String nom,
                    String prenom,
                    String email,
                    String password) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Users(String nom,
                    String prenom,
                    String email,
                    String password) {
                        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Associations getAssociation() {
        return this.association;
    }

    public void setAssociation(Associations association) {
        this.association = association;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
