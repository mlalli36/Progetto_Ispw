package com.example.progetto_ispw.user;

public class UserEntity {

    private String email;
    private String password;
    private String tipoaccesso;
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

    public String getEmail() {
        return email;
    }

    public String getTipoaccesso() {
        return tipoaccesso;
    }


}