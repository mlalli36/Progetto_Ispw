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
    private Double distance;

    private double[] coordinates = new double[2];
    public void setCoordinates(double lat, double lng) {
        double[] coord = new double[2];
        coord[0] = lat;
        coord[1] = lng;
        this.coordinates = coord;
    }


    public double getLat() {
        return this.coordinates[0];
    }

    public double getLng() {
        return this.coordinates[1];
    }

    public  String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getSurname(){return surname;}
    public String getWork() {
        return work;
    }
    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
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


    public void setDistance(double distance) {this.distance=distance;
    }

    public double getDistance() { return distance;
    }
}
