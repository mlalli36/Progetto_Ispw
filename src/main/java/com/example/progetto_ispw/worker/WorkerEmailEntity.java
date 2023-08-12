package com.example.progetto_ispw.worker;

public class WorkerEmailEntity {
    private String email;
    private static WorkerEmailEntity singleInstance = null;
    public static WorkerEmailEntity getInstance(){
        if (singleInstance == null)
            singleInstance = new WorkerEmailEntity();
        return singleInstance;
    }
    //WEE= WorkerEmailEntity
    public String getEmailWEE() {
        return email;
    }
    public void setEmailWEE(String email) {
        this.email = email;
    }
}
