package cnam.sebastienmarie.cloudassociation.common.campagne.domain;

import java.util.Date;

import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "campagnes_goodies")
public class CampagneGoodies{

    @Id
    private String id;
 
    @Column(name="nom")
    private String nom;

    @Column(columnDefinition="DATE") 
    private Date date_debut;

    @Column(columnDefinition="DATE") 
    private Date date_fin;

    private Long prix;

    private Long quantite;

    @ManyToOne
    @JoinColumn(referencedColumnName="id", name="id_association")
    private Associations association;

    public CampagneGoodies(){

    }

    public CampagneGoodies(String id){
        this.id = id;
    }

    public CampagneGoodies(String id,
                            String nom,
                            Date date_debut,
                            Date date_fin,
                            Long prix,
                            Long quantite,
                            Associations association){

        this.id = id;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
        this.quantite = quantite;
        this.association = association;

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

    public Long getQuantite() {
        return this.quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
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

    public Long getPrix() {
        return this.prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public Associations getAssociation() {
        return this.association;
    }

    public void setAssociation(Associations association) {
        this.association = association;
    }
}
