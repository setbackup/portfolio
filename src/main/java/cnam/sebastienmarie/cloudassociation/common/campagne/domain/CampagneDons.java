// Source code is decompiled from a .class file using FernFlower decompiler.
package cnam.sebastienmarie.cloudassociation.common.campagne.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;

@Entity
@Table(name = "campagnes_dons")
public class CampagneDons {

   @Id
   private String id;

   @Column(
      name = "nom"
   )
   private String nom;

   @Column(
      columnDefinition = "DATE"
   )
   private Date date_debut;

   @Column(
      columnDefinition = "DATE"
   )
   private Date date_fin;

   private long objectif;
   
   @ManyToOne
   @JoinColumn(
      referencedColumnName = "id",
      name = "id_association"
   )
   private Associations association;

   protected CampagneDons() {
   }

   public CampagneDons(String id,
                        String nom,
                        Date date_debut,
                        Date date_fin,
                        long objectif,
                        Associations association) {

      this.id = id;
      this.nom = nom;
      this.date_debut = date_debut;
      this.date_fin = date_fin;
      this.objectif = objectif;
      this.association = association;
   }

   public CampagneDons(String id) {
      this.id = id;
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

   public void setNom_campagne(String nom) {
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

   public long getObjectif() {
      return this.objectif;
   }

   public void setObjectif(long objectif) {
      this.objectif = objectif;
   }

   public Associations getAssociation() {
      return this.association;
   }

   public void setAssociation(Associations association) {
      this.association = association;
   }
}
