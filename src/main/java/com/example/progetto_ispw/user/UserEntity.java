package com.example.progetto_ispw.user;

public class UserEntity {

    private String email;
    private String password;
    private String tipoaccesso;
    private String description;
    private String location;
    private String address;
    private String name;
    private String surname;
    private String work;
    private static UserEntity singleInstance = null;


    private UserEntity(){}

    public static UserEntity getInstance(){
        if (singleInstance == null)
            singleInstance = new UserEntity();
        return singleInstance;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipoaccesso(String tipoaccesso) {
        this.tipoaccesso = tipoaccesso;
    }

    public String getPassword() {
        return password;
    }

    public void setDescription(String description) {this.description = description;}

    public void setWork(String work) { this.work = work;}

    public void setName(String nome) {this.name =nome;}

    public void setSurname(String cognome) {this.surname=cognome;}


    public void setAddress(String indirizzo) {this.address=indirizzo;}

    public void setLocation(String località) {this.location= località;}
}