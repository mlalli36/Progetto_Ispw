package com.example.progetto_ispw.home;


import javafx.scene.control.Button;

public class HomeBean {
    private ResultSetEntity resultSet;
    protected String nameWork= null;
    protected String jobWork=null;
    protected String locationWork = null;

    public  ResultSetEntity getResultSet() {
        return resultSet;
    }




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


}