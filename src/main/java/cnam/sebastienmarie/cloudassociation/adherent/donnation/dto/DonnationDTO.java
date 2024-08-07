package cnam.sebastienmarie.cloudassociation.adherent.donnation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DonnationDTO {

    public String nom;
    public String montant;
    public String id_adherent;
    public String id_campagnedon;

    public DonnationDTO(@JsonProperty("montant") String montant,
                        @JsonProperty("id_campagne") String id_campagnedon){
        
        this.montant = montant;
        this.id_campagnedon = id_campagnedon;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMontant() {
        return this.montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getId_adherent() {
        return this.id_adherent;
    }

    public void setId_adherent(String id_adherent) {
        this.id_adherent = id_adherent;
    }

    public String getId_campagnedon() {
        return this.id_campagnedon;
    }

    public void setId_campagnedon(String id_campagnedon) {
        this.id_campagnedon = id_campagnedon;
    }
}
