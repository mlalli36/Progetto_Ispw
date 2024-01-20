package com.example.progetto_ispw.worker;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsController;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.state.AppointementState;


public class InfoAppoinEntity {

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
    private AppointementState statoAppuntamento;

    public void setStatoAppuntamento(AppointementState stato) {
        this.statoAppuntamento = stato;
    }

    public void elaboraAppuntamento(NotificationsController context, String data, String orario, String email) throws UserNotFoundException {
        statoAppuntamento.elaboraAppuntamento(context, data, orario, email);
    }

    // finisce qui la parte da cancellare


}
