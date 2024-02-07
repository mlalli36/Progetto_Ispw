package com.example.progetto_ispw.savehoursslots.observer;


public abstract class Subject {
    public void attach(Observer o){}
    public void detach(Observer o){}
    protected void notifyObservers(){

    }
    public void setState(boolean s){

    }



}
