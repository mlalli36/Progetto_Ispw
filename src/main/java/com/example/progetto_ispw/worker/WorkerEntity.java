package com.example.progetto_ispw.worker;

import com.example.progetto_ispw.user.UserEntity;

public class WorkerEntity {
    private String email;
    private String description;
    private String location;
    private String address;
    private  String name;
    private String surname;
    private  String work;

    private static WorkerEntity singleInstance = null;


    private WorkerEntity(){}

    public static WorkerEntity getInstance(){
        if (singleInstance == null)
            singleInstance = new WorkerEntity();
        return singleInstance;
    }

    public  String getName() {
        return name;
    }

    public String getWork() {
        return work;
    }
    public String getLocation() {
        return location;
    }

    public void setDescription(String description) {this.description = description;}

    public void setWork(String work) { this.work = work;}

    public void setName(String nome) {this.name =nome;}
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSurname(String cognome) {this.surname=cognome;}


    public void setAddress(String indirizzo) {this.address=indirizzo;}

    public void setLocation(String località) {this.location= località;}


}
