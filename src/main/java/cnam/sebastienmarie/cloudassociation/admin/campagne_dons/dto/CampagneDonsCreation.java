package cnam.sebastienmarie.cloudassociation.admin.campagne_dons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CampagneDonsCreation {
   
   private String nom;
   private String date_debut;
   private String date_fin;
   private long objectif;

   public CampagneDonsCreation(@JsonProperty("nom") String nom, 
                                 @JsonProperty("date_debut") String date_debut, 
                                 @JsonProperty("date_fin") String date_fin, 
                                 @JsonProperty("objectif") long objectif) {
      this.nom = nom;
      this.date_debut = date_debut;
      this.date_fin = date_fin;
      this.objectif = objectif;
   }

   public String toString() {
      return "CampagneDonsCreation { \nnom='" + this.nom + "',\ndate_debut='" + this.date_debut + "',\ndate_fin='" + this.date_fin + "',\nobjectif='" + this.objectif + "'\n}";
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

   public long getObjectif() {
      return this.objectif;
   }

   public void setObjectif(long objectif) {
      this.objectif = objectif;
   }
}
