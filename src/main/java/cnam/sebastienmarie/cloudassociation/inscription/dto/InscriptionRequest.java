package cnam.sebastienmarie.cloudassociation.inscription.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.*;


public class InscriptionRequest {
    
    @NotNull(message="Le nom n'est pas présent")
    @NotBlank(message = "Le nom est vide")
    private String nom;


    @NotNull(message="Le prenom n'est pas présent")
    @NotBlank(message = "Le prenom est vide")
    private String prenom;

    @NotNull(message="L'email' n'est pas présent")
    @NotBlank(message = "L'email'est vide")
    private String email;

    @NotNull(message="Le password n'est pas présent")
    @NotBlank(message = "Le password est vide")
    private String password;

    @NotNull(message="Le nom de l'association n'est pas présent")
    @NotBlank(message = "Le nom de l'association est vide")
    private String nom_association;

    @NotNull(message="L'adresse n'est pas présent")
    @NotBlank(message = "L'adresse est vide")
    private String adresse_association;

    @NotNull(message="Le code postal n'est pas présent")
    @NotBlank(message = "Le code postal est vide")
    private String codePostal_association;

    @NotNull(message="La ville n'est pas présent")
    @NotBlank(message = "La ville est vide")
    private String ville_association;
   
    public InscriptionRequest(@JsonProperty("nom") String nom, 
                                @JsonProperty("prenom") String prenom, 
                                @JsonProperty("email") String email, 
                                @JsonProperty("password") String password,
                                @JsonProperty("nom_association") String nom_association, 
                                @JsonProperty("adresse_association") String adresse_association,
                                @JsonProperty("codePostal_association") String codePostal_association, 
                                @JsonProperty("ville_association") String ville_association) {
                                    
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.nom_association = nom_association;
        this.adresse_association = adresse_association;
        this.codePostal_association = codePostal_association;
        this.ville_association = ville_association;        
    }

    public String toString(){
        return "InscriptionRequest { \n"+
            "nom='"+this.nom+"\',\n" +
            "prenom='"+this.prenom+"\',\n" +
            "email='"+this.email+"\',\n" +
            "password='"+this.password+"\',\n" +
            "nom_association='"+this.nom_association+"\',\n" +
            "adresse_association='"+this.adresse_association+"\',\n" +
            "codePostal_association='"+this.codePostal_association+"\',\n" +
            "ville_association='"+this.ville_association+"\',\n" +
        "}";
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom_association() {
        return this.nom_association;
    }

    public void setNom_association(String nom_association) {
        this.nom_association = nom_association;
    }

    public String getAdresse_association() {
        return this.adresse_association;
    }

    public void setAdresse_association(String adresse_association) {
        this.adresse_association = adresse_association;
    }

    public String getCodePostal_association() {
        return this.codePostal_association;
    }

    public void setCodePostal_association(String codePostal_association) {
        this.codePostal_association = codePostal_association;
    }

    public String getVille_association() {
        return this.ville_association;
    }

    public void setVille_association(String ville_association) {
        this.ville_association = ville_association;
    }
}
