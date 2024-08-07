package cnam.sebastienmarie.cloudassociation.adherent.goodies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoodiesDTO {

    private String quantite;

    private String id_campagne;


    public GoodiesDTO(@JsonProperty("quantite") String quantite,
                        @JsonProperty("id_campagne") String id_campagne){
        this.quantite = quantite;
        this.id_campagne = id_campagne;
    }

    public String getQuantite() {
        return this.quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getId_campagne() {
        return this.id_campagne;
    }

    public void setId_campagne(String id_campagne) {
        this.id_campagne = id_campagne;
    }
}
