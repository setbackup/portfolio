package cnam.sebastienmarie.cloudassociation.inscription.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AssociationDTO {


    @NotNull(message="Le nom de l'association n'est pas présent")
    @NotBlank(message = "Le nom de l'association est vide")
    private String nom;

    @NotNull(message="L'adresse n'est pas présent")
    @NotBlank(message = "L'adresse est vide")
    private String adresse;

    @NotNull(message="Le code postal n'est pas présent")
    @NotBlank(message = "Le code postal est vide")
    private String codePostal;

    @NotNull(message="La ville n'est pas présent")
    @NotBlank(message = "La ville est vide")
    private String ville;

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

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
}
