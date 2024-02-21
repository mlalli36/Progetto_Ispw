package com.example.progetto_ispw.home;



public class HomeBean {
    private ResultSetEntity resultSet;
    protected String nameWork= null;
    protected String jobWork=null;
    protected String locationWork = null;
    private String emailsearch;
    private int radius;
    private int CAP;
    private String city;




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

    /*
    prova per indirizzo completo
    public String getLocationWork() {
        return locationWork;
    }*/
    public String getLocationWork() {
        StringBuilder addressBuilder = new StringBuilder();
        if (locationWork != null && !locationWork.isEmpty()) {
            addressBuilder.append(locationWork);
            addressBuilder.append(", ");
        }
        if (city != null && !city.isEmpty()) {
            addressBuilder.append(city);
            addressBuilder.append(", ");
        }
        if (CAP != 0) {
            addressBuilder.append(CAP);
        }
        return addressBuilder.toString();
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

    public int getCAP() {
        return CAP;
    }

    public void setCAP(int CAP) {
        this.CAP = CAP;
    }
}