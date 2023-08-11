package com.example.progetto_ispw.worker;

public class InfoAppoinEntity2 {
public static InfoAppoinEntity2 getInstance() {
        if (singleInstance == null)
            singleInstance = new InfoAppoinEntity2();
        return singleInstance;
    }
    private static InfoAppoinEntity2 singleInstance = null;

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
    public String getCName(){return clientName;}
    public String getCSurname(){return clientSurname;}
    public String getCEmail(){return clientEmail;}
    public String getCNumber(){return clientNumber;}
    public String getdescriptionWork(){return workDescr;}
}
