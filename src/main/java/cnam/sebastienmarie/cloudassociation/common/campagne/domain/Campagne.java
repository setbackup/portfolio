package cnam.sebastienmarie.cloudassociation.common.campagne.domain;

import java.util.Date;

public class Campagne {
    
    private String id;
    private String id_association;
    private String nom_association;
    private String nom;
    private Date date_debut;
    private Date date_fin;
    private String type;

    public Campagne(String type,
                    String id, 
                    String id_association,
                    String nom, 
                    String nom_association, 
                    Date date_debut,
                    Date date_fin) {
        
        this.id = id;
        this.id_association = id_association;
        this.nom = nom;
        this.nom_association = nom_association;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type = type;
    }

    public String toString(){
        return "Campagne {"+
        "\ntype : '"+this.type+"'"+
        "\nid : '"+this.id+"'"+
        "\nid_association : '"+this.id_association+"'"+
        "\nnom : '"+this.nom+"'"+
        "\nnom_association : '"+this.nom_association+"'"+
        "\ndate_debut : '"+this.date_debut+"'"+
        "\ndate_fin : '"+this.date_fin+"'"+
        "}";
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_association() {
        return this.id_association;
    }

    public void setId_association(String id_association) {
        this.id_association = id_association;
    }

    public String getNom_association() {
        return this.nom_association;
    }

    public void setNom_association(String nom_association) {
        this.nom_association = nom_association;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_debut() {
        return this.date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return this.date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
    
}
