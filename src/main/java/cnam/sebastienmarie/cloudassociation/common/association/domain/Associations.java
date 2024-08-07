package cnam.sebastienmarie.cloudassociation.common.association.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "associations")
public class Associations {

    @Id
    String id;

    String nom;

    String adresse;
    
    String code_postal;
    
    String ville;

    protected Associations(){

    }

    public Associations(String id) {
        this.id = id;
    }

    public Associations(String nom, String adresse, String code_postal, String ville){
        this.nom = nom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
    }

    public Associations(String id, String nom, String adresse, String code_postal, String ville){
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
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

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return this.code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


    
}
