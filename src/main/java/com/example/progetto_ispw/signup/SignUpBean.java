package com.example.progetto_ispw.signup;


import com.example.progetto_ispw.login.LoginBean;

public class SignUpBean extends LoginBean {

    private String Psw;
    private String confirmPsw;
    private boolean isWorker;


    public void setWorker(boolean worker) {
        isWorker = worker;
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

    public boolean isWorker() {
        return isWorker;
    }



    public String getPsw() {
        return Psw;
    }

    public String getConfirmPsw() {
        return confirmPsw;
    }
}

