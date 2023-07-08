package com.example.progetto_ispw.home;

public class ResultElement {
    private String nameWorker;
    private String surnameWorker;
    private String jobWork;
    private String locationWorker;
    private String descriptionWorker;

    private String emailWorker;

    public void setNameWorker(String nameWorker) {
        this.nameWorker= nameWorker;
    }

    public void setJobWork(String jobWork) {
        this.jobWork= jobWork;
    }

    public void setLocationWork(String location) {
        this.locationWorker= location;
    }

    public void setDescriptionWorker(String descriptionWorker) {
        this.descriptionWorker = descriptionWorker;
    }
    public void setEmailWorker(String emailWorker) {
        this.emailWorker= emailWorker;
    }

    public String getWorkerName() {
    return nameWorker;    }

    public String getWorkerSurname() {
        return surnameWorker;}

    public String getWorkerAddress() {
        return locationWorker;}

    public String getWorkerDescription() {
    return descriptionWorker;}

    public String getJobWorker() {
        return jobWork;
    }

    public String getLocationWorker() {
        return locationWorker;
    }
    public String getWorkerEmail(){return emailWorker;}
}
