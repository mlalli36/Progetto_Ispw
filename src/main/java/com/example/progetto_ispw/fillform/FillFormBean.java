package com.example.progetto_ispw.fillform;

import com.example.progetto_ispw.fillform.exception.*;
import com.example.progetto_ispw.login.exception.LoginFailedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FillFormBean {
    protected String name;
    protected String surname;
    protected String emailUser;
    protected String emailWorker;
    protected String description;
    protected String phone;
    protected String date;
    private String time;
    private String emailSearch;


    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9.%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    //tutti i set per ogni campo
    public void setEmailUser(String emailUser) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailUser);
        if (!matcher.find()){throw new InvalidEmailFormatException("");}
        this.emailUser = emailUser;
    }
    public void setEmailWorker(String emailWorker) {
        this.emailWorker = emailWorker;
    }

    public void setName(String name){
        if (name.isEmpty()){
            throw new EmptyNameFieldException("");}

        this.name=name;
    }
    public void setSurname(String surname){
        if (surname.isEmpty()){
            throw new EmptySurameFieldException("");}
        this.surname=surname;
    }
    public void setDescription(String description){
        if (description.isEmpty()) {
            throw new EmptyDescriptionFieldException("");}
        this.description = description;
    }

    public void setPhone(String phone){
        String regex=  "^[0-9]+$";
        Pattern controllo= Pattern.compile(regex);
        Matcher matcher=controllo.matcher(phone);
        if(matcher.matches()){
        this.phone=phone;} else{
            throw new NotValidNumberPhoneException("");}
    }


    public void setDate(String date)  {
        if(date.isEmpty()){
            throw new EmptyDateFieldException("");}
        this.date = date;
    }

    public void setTime(String time) {
        this.time=time;}
    //tutti i get per ogni campo
    public String getEmailUser()     {return emailUser;}
    public String getName()          {return name;}
    public String getSurname()       {return surname;}
    public String getDescription()   {return description;}
    public String getPhone()         {return phone;}

    public String getDate()          {return date;}

    public String getEmailWorker()   {return emailWorker;}
    public String getTime(){return time;}

    public void setEmail(String emailsearch) { this.emailSearch= emailsearch;}

    public String getemailsearch() { return emailSearch;}
}
