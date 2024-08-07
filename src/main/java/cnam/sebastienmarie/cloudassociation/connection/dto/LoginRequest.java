package cnam.sebastienmarie.cloudassociation.connection.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

    private String email;
    private String password;

    public LoginRequest(@JsonProperty("email")String email, 
                        @JsonProperty("password") String password){
                            
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassdword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "LoginRequest { email : "+this.getEmail()+" password : "+this.getPassdword()+"}";
    }

}
