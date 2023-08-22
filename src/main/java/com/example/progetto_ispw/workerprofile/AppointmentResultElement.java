package com.example.progetto_ispw.workerprofile;

public class AppointmentResultElement {

    private String workerEmail;
    private String clientEmail;
    private String clientName;
    private String clientSurname;
    private String dateAppointment;
    private String clientNumber;
    private String descriptionWork;
    private String time;
    public void setWorkerEmail(String wEmail) {this.workerEmail= wEmail;}

    public void setClientEmail(String cEmail) { this.clientEmail= cEmail;}

    public void setClientName(String cName) { this.clientName =cName;}

    public void setClientSurname(String cSurname) { this.clientSurname= cSurname;}

    public void setDateAppointment(String dAppo) { this.dateAppointment=dAppo;}

    public void setClientNumber(String cNumber) { this.clientNumber=cNumber;}

    public void setDescription(String getdescriptionWork) { this.descriptionWork=getdescriptionWork;}

    public void setTime(String time) {this.time = time;}

    public String getCEmail() { return clientEmail;}

    public String getCName() { return clientName;}

    public String getCSurname() { return clientSurname;}

    public String getCNumber() { return clientNumber;}

    public String getdescriptionWork() { return descriptionWork;}

    public String getTime() { return time;}

    public String getDAppo() { return dateAppointment;}
}
