package com.example.progetto_ispw.SignUp;


import com.example.progetto_ispw.login.LoginBean;

public class SignUpBean extends LoginBean {

    private String Psw;
    private String confirmPsw;
    private boolean isOwner;


    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public void setPsw(String Psw) {
        if (Psw.isEmpty())
            throw new IllegalArgumentException("Password cannot be empty");
        this.Psw = Psw;
    }

    public void setConfirmPsw(String confirmPsw) {
        if (confirmPsw.isEmpty())
            throw new IllegalArgumentException("Password cannot be empty");
        this.confirmPsw = confirmPsw;
    }

    public boolean isOwner() {
        return isOwner;
    }


    public String getFirstPsw() {
        return Psw;
    }

    public String getSecondPsw() {
        return confirmPsw;
    }
}