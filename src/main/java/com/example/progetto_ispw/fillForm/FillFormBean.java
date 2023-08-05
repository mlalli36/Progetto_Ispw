package com.example.progetto_ispw.fillForm;

import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;

public class FillFormBean {
    protected String name;
    protected String surname;
    protected String emailUser;
    protected String emailWorker;
    protected String description;
    protected String phone;
    protected String date;
    private String time;


    //tutti i set per ogni campo
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    public void setEmailWorker(String emailWorker) {
        this.emailWorker = emailWorker;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public void setPhone(String phone){
        this.phone=phone;
        //aggiungere un controllo per vedere se sono solo numeri!

    }


    public void setDate(String date)  {
        this.date = date;
    }

    public void setTime(String appuntamento) {this.time=time;}
    //tutti i get per ogni campo
    public String getEmailUser()     {return emailUser;}
    public String getName()          {return name;}
    public String getSurname()       {return surname;}
    public String getDescription()   {return description;}
    public String getPhone()         {return phone;}

    public String getDate()          {return date;}

    public String getEmailWorker()   {return emailWorker;}
    public String getTime(){return time;}
}
