package cnam.sebastienmarie.cloudassociation.inscription.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
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

   @Valid
   @NotNull(message = "l'asociation doit être present.")
   private AssociationDTO associationDto;
   
    public InscriptionRequest(@JsonProperty("nom") String nom, 
                                @JsonProperty("prenom") String prenom, 
                                @JsonProperty("email") String email, 
                                @JsonProperty("password") String password,
                                @JsonProperty("association") AssociationDTO associationDto) {
                                    
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.associationDto = associationDto;
    }

    public String toString(){
        return "InscriptionRequest { \n"+
            "nom: '"+this.nom+"\',\n" +
            "prenom: '"+this.prenom+"\',\n" +
            "email: '"+this.email+"\',\n" +
            "password: '"+this.password+"\',\n" +
             "association {"+
                "\t nom: '"+this.associationDto.getNom()+"\',\n" +
                "\t adresse: '"+this.associationDto.getAdresse()+"\',\n" +
                "\t codePostal: '"+this.associationDto.getCodePostal()+"\',\n" +
                "\t ville: '"+this.associationDto.getVille()+"\',\n" +
            "}"+
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

    public AssociationDTO getAssociationDto() {
        return this.associationDto;
    }

    public void setAssociationDto(AssociationDTO associationDto) {
        this.associationDto = associationDto;
    }
    
}
