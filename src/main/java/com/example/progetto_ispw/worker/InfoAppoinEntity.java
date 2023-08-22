package com.example.progetto_ispw.worker;

import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;


public class InfoAppoinEntity {
    /*public static InfoAppoinEntity getInstance() {
        if (singleInstance == null)
            singleInstance = new InfoAppoinEntity();
        return singleInstance;
    }
    private static InfoAppoinEntity singleInstance = null;*/

    private String workerEmail;
    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private String dateAppoint;
    private String clientNumber;
    private String workDescr;
    private String timeDate;
    private Integer accept;

    public void setWEmail(String workerEmail) {this.workerEmail=workerEmail;}

    public void setCname(String clientName) {this.clientName=clientName;}

    public void setCsurname(String clientSurname) {this.clientSurname=clientSurname;}

    public void setCEmail(String clientEmail) {this.clientEmail=clientEmail;}

    public void setDAppo(String dateAppoint) {this.dateAppoint=dateAppoint;}

    public void setCNumber(String clientNumber) {this.clientNumber=clientNumber;}

    public void setDescription(String workDescr) {this.workDescr=workDescr;}

    public void setTime(String timeDate) {this.timeDate=timeDate;}
    public void setAccept(int accept) { this.accept= accept;
        System.out.println("Setaccept:"+ accept);
    }

    public String getWEmail() { return workerEmail;}

    public String getDAppo() { return dateAppoint;}

    public String getTime() {return timeDate;}
    //prova da cancellare in caso non vada bene
    public String getCName(){return clientName;}
    public String getCSurname(){return clientSurname;}
    public String getCEmail(){return clientEmail;}
    public String getCNumber(){return clientNumber;}
    public String getdescriptionWork(){return workDescr;}

    public Integer getAccept() {
        System.out.println("accept:"+ accept);
        return accept;

    }


    // finisce qui la parte da cancellare


}
