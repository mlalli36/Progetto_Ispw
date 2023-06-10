package com.example.progetto_ispw.home;

public class ResultElement {
    private String nameWorker;
    private String surnameWorker;
    private String jobWork;
    private String locationWorker;
    private String descriptionWorker;
    public void setNameWorker(String nameWorker) {
        this.nameWorker= nameWorker;
    }

    public void setJobWork(String jobWork) {
        this.jobWork= jobWork;
    }

    public void setLocationWork(String location) {
        this.locationWorker= location;
    }

    public String getWorkerName() {
    return nameWorker;    }

    public String getWorkerSurname() {
        return surnameWorker;}

    public String getWorkerAddress() {
        return locationWorker;}

    public String getWorkerDescription() {
    return descriptionWorker;}
}
