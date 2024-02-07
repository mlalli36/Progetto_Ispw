package com.example.progetto_ispw.savehoursslots.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    public void attach(Observer o){}
    public void detach(Observer o){}
    protected void notifyObservers(){

    }
    public void setState(boolean s){

    }



}
