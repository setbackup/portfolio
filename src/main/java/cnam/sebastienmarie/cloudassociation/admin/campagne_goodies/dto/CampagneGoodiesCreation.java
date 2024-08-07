package cnam.sebastienmarie.cloudassociation.admin.campagne_goodies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;

public class CampagneGoodiesCreation {


    private String nom;
    private String date_debut;
    private String date_fin;
    private long prix;
    private long quantite;

    public CampagneGoodiesCreation(@JsonProperty("nom") String nom,
                                    @JsonProperty("date_debut") String date_debut,
                                    @JsonProperty("date_fin") String date_fin,
                                    @JsonProperty("prix") long prix,
                                    @JsonProperty("quantite") long quantite){

        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String toString(){
        return "CampangeGoodies{"+
        "nom="+this.nom+
        "date_debut="+this.date_debut+
        "date_fin="+this.date_fin+
        "prix="+this.prix+
        "quantite="+this.quantite+
        "}";
    }
    
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate_debut() {
        return this.date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return this.date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public long getPrix() {
        return this.prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    public long getQuantite() {
        return this.quantite;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

    public void save(CampagneGoodiesCreation campagneGoodiesRequest, Associations association) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
