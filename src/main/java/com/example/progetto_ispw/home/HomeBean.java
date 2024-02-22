package com.example.progetto_ispw.home;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeBean {
    private ResultSetEntity resultSet;
    protected String nameWork= null;
    protected String jobWork=null;
    protected String locationWork = null;
    private boolean distanceIsImportant = false;
    private boolean availabilityIsImportant = false;
    private String emailsearch;
    private int radius;
    private String cap1;
    private String city;
    private String date;


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
    public String getDate()          {return date;}


    public String getLocation() {
        return locationWork;
    }


    public void setDistanceIsImportant(boolean distanceIsImportant) {
        this.distanceIsImportant = distanceIsImportant;
    }
    public void setAvailabilityIsImportant(boolean availabilityIsImportant) {
        this.availabilityIsImportant = availabilityIsImportant;
    }


    public boolean getIsDistanceIsImportant() {
        return distanceIsImportant;
    }

    public boolean getIsAvailabilityIsImportant() {
        return availabilityIsImportant;
    }




    public void setDate(String date)  {
        this.date = date;
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

    public void setRadius(int radius) {
        this.radius= radius;
    }

    public int getRadius() { return radius;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCAP() {
        return cap1;
    }

    public void setCAP(String CAP) {
        Pattern validCAP = Pattern.compile("^\\d{5}$"); //valida sintatticamente il CAP
        Matcher m = validCAP.matcher(CAP);
        if (!m.find()){
            throw new IllegalArgumentException("Invalid ZIP code!");
        }
        this.cap1 = CAP;
    }
}