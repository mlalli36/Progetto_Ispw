package com.example.progetto_ispw.signup;


import com.example.progetto_ispw.login.LoginBean;

public class SignUpBean extends LoginBean {

    private String psw;
    private String confirmPsw;
    private boolean isWorker;

    private String name;
    private String surname;

    public void setName(String name) {
        this.name=name;
    }

    public void setSurname(String surname) {
        this.surname=surname;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }


    public void setPsw(String psw) {
        if (psw.isEmpty())
            throw new IllegalArgumentException("Password cannot be empty");
        this.psw = psw;
    }

    public void setConfirmPsw(String confirmPsw) {
        if (confirmPsw.isEmpty())
            throw new IllegalArgumentException("Password cannot be empty");
        this.confirmPsw = confirmPsw;
    }

    public boolean isWorker() {
        return isWorker;
    }



    public String getPsw() {
        return psw;
    }

    public String getConfirmPsw() {
        return confirmPsw;
    }


    public String getName() { return name;
    }

    public String getSurname() { return surname;
    }


}

