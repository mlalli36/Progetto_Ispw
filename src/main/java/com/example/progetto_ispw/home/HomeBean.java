package com.example.progetto_ispw.home;


import javafx.scene.control.Button;

public class HomeBean {
    private ResultSetEntity resultSet;
    protected String nameWork= null;
    protected String jobWork=null;
    protected String locationWork = null;
    private String emailsearch;




    public void setNameWork(String nameWork) {
        this.nameWork= nameWork;
    }

    public void setJobWork(String jobWork) {
        this.jobWork= jobWork;
    }

    public void setLocationWork(String locationWork) {
        this.locationWork= locationWork;
    }




    public String getNameWork() {
        return nameWork;
    }

    public String getJobWork() {
        return jobWork;
    }

    public String getLocationWork() {
        return locationWork;
    }


    public void setEmail(String emailsearch) {
        this.emailsearch= emailsearch;
    }

    public String getemailsearch() {return emailsearch;}
    public  ResultSetEntity getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSetEntity resultSet) {
        this.resultSet= resultSet;
    }
}