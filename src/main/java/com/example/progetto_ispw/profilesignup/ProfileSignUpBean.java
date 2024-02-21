package com.example.progetto_ispw.profilesignup;

import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileSignUpBean {

    protected String  email = null;
    protected String  name = null;
    protected String  surname = null;
    protected String  location = null;
    protected String  description= null;
    protected String  address= null;
    protected String  work= null;
    protected int  cap;


     private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9.%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);





    public void setEmail(String email) throws LoginFailedException, UserNotFoundException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.find())
            throw new LoginFailedException("Invalid email, try again!");

        this.email = email;
}


    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty!");

        this.name = name;
    }
    public void setSurname(String surname) {
        if (surname.isEmpty())
            throw new IllegalArgumentException("Surname cannot be empty!");

        this.surname = surname;
    }

    public void setAddress(String address) {
        if (address.isEmpty())
            throw new IllegalArgumentException("Address cannot be empty!");

        this.address= address;
    }

    public void setLocation(String location) {
        if (location.isEmpty())
            throw new IllegalArgumentException("Location cannot be empty!");

        this.location= location;
    }

    public void setWork(String work) {
        if (work.isEmpty())
            throw new IllegalArgumentException("Work cannot be empty!");

        this.work= work;
    }

    public void setDescription(String description) {
        if (description.isEmpty())
            throw new IllegalArgumentException("Description cannot be empty!!!");

        this.description= description;
    }





    public String getEmail() {
        return email;
    }


    public String getDescription() { return description;}

    public String getWork() {return work;}

    public String getName() {return name;}

    public String getSurname() {return surname;}

   // public String getAddress() {return address;}
    public String getAddress() {
        StringBuilder addressBuilder = new StringBuilder();
        if (address != null && !address.isEmpty()) {
            addressBuilder.append(address);
            addressBuilder.append(", ");
        }
        if (location != null && !location.isEmpty()) {
            addressBuilder.append(location);
            addressBuilder.append(", ");
        }
        if (cap != 0) {
            addressBuilder.append(cap);
        }
        return addressBuilder.toString();
    }

    public String getLocation() {return location;}
}
