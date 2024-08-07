package cnam.sebastienmarie.cloudassociation.common.campagne.domain;

import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="goodies")
public class Goodies {
 
    @Id
    private String id;

    private String quantite;

    @OneToOne
    @JoinColumn(
      referencedColumnName = "id",
      name = "id_adherent"
    )
    private Adherent adherent;

    @OneToOne
    @JoinColumn(
      referencedColumnName = "id",
      name = "id_campagne"
    )
    private CampagneGoodies campagneGoodies;

    public Goodies(){

    }

    public Goodies(String id, 
                    String quantite,
                    Adherent adherent, 
                    CampagneGoodies campagneGoodies){
        
        this.id = id;
        this.adherent = adherent;
        this.campagneGoodies = campagneGoodies;
        this.quantite = quantite;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantite() {
        return this.quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Adherent getAdherent() {
        return this.adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public CampagneGoodies getCampagneGoodies() {
        return this.campagneGoodies;
    }

    public void setCampagneGoodies(CampagneGoodies campagneGoodies) {
        this.campagneGoodies = campagneGoodies;
    }

}
