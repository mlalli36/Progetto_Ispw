package com.example.progetto_ispw.worker;

public class InfoAppoinEntity {
    private String workerEmail;
    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private String dateAppoint;
    private String clientNumber;
    private String workDescr;
    private String timeDate;

    public void setWEmail(String workerEmail) {this.workerEmail=workerEmail;}

    public void setCname(String clientName) {this.clientName=clientName;}

    public void setCsurname(String clientSurname) {this.clientSurname=clientSurname;}

    public void setCEmail(String clientEmail) {this.clientEmail=clientEmail;}

    public void setDAppo(String dateAppoint) {this.dateAppoint=dateAppoint;}

    public void setCNumber(String clientNumber) {this.clientNumber=clientNumber;}

    public void setDescription(String workDescr) {this.workDescr=workDescr;}

    public void setTime(String timeDate) {this.timeDate=timeDate;}


    public String getWEmail() { return workerEmail;}

    public String getDAppo() { return dateAppoint;}

    public String getTime() {return timeDate;}
}
