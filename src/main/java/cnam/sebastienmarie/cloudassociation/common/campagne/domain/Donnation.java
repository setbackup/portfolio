package cnam.sebastienmarie.cloudassociation.common.campagne.domain;

import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "donnations")
public class Donnation {
    
    @Id
    private String id;

    private String montant;
    
    @OneToOne
    @JoinColumn(
      referencedColumnName = "id",
      name = "id_adherent"
   )
    private Adherent adhesion;
    
    @OneToOne
    @JoinColumn(
      referencedColumnName = "id",
      name = "id_campagne"
   )
    private CampagneDons campagneDon;

    protected Donnation(){
        
    }

    public Donnation(String montant, 
                        String id,
                        Adherent adhesion,
                        CampagneDons campagneDon){
        
        this.montant = montant;
        this.id = id;
        this.adhesion = adhesion;
        this.campagneDon = campagneDon;

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMontant() {
        return this.montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public Adherent getAdhesion() {
        return this.adhesion;
    }

    public void setAdhesion(Adherent adhesion) {
        this.adhesion = adhesion;
    }
   
    public CampagneDons getCampagneDon() {
        return this.campagneDon;
    }

    public void setCampagneDon(CampagneDons campagneDon) {
        this.campagneDon = campagneDon;
    }
}
