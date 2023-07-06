package com.example.progetto_ispw.userProfile;

public class UserProfileBean  {
    private String email;
    private String name;
    private String surname;

    public void setName(String name) {this.name=name;}

    public void setSurname(String surname) {this.surname=surname;}


    public void setEmail(String email) {this.email=email;}

    public String getEmail() {return email;}

    public String getSurname() {return surname;}

    public String getName() {return name;}
}
