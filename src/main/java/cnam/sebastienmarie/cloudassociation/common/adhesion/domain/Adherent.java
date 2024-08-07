package cnam.sebastienmarie.cloudassociation.common.adhesion.domain;

import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Adherent")
public class Adherent {

    @Id
    private String id;

    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private String ville;
    private String code_postal;

    @OneToOne
    @JoinColumn(
        referencedColumnName = "id",
        name = "id_association"
    )
    private Associations associations;

    protected Adherent(){
        
    }

    public Adherent(String id){
        this.id = id;
    }

    public Adherent(String id, 
                    String nom,
                    String prenom,
                    String email, 
                    String password,
                    String adresse, 
                    String ville, 
                    String code_postal,
                    Associations associations){

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.associations = associations;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return this.code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    } 

    public Associations getAssociations() {
        return this.associations;
    }

    public void setAssociations(Associations associations) {
        this.associations = associations;
    }
}
