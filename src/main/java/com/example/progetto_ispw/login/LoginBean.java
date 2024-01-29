package com.example.progetto_ispw.login;

import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginBean {

    protected String email = null;
    protected String password = null;



    //Regex di una email valida, da usare per confrontarla con quella dell'utente
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9.%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void setEmail(String email) throws LoginFailedException, UserNotFoundException{
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.find())
            throw new LoginFailedException("Invalid email, try again!");

        this.email=email;

    }
    public void setEmail1(String email) throws LoginFailedException, UserNotFoundException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.find())
            throw new LoginFailedException("Invalid email, try again!");

        else {
            if (!isEmailAlreadyInDatabase(email)) {
                this.email = email;
            } else {
                throw new LoginFailedException( "This email is already recorded!");
            }

        }

    }
    private boolean isEmailAlreadyInDatabase(String email) throws UserNotFoundException {
        UserDAO UD = UserDAO.getInstance();
        String EMAIL = UD.checkEmail(email);

        // Controlla se l'email è presente nel database, controllo messo per evitare quando torna il null
        if (EMAIL != null && EMAIL.equals(email)) {
            return true;
        }
      /*  if (EMAIL.equals(email)){
            return true;
        }*/
        return false;
    }

    public void setPassword(String password) {
        if (password.isEmpty())
            throw new IllegalArgumentException("Password cannot be empty!");

        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}