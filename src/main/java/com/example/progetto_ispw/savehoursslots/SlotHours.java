package com.example.progetto_ispw.savehoursslots;

import com.example.progetto_ispw.savehoursslots.observer.Observer;
import com.example.progetto_ispw.savehoursslots.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class SlotHours extends Subject {
    private List<Observer> observes = new ArrayList<>();

    private boolean state = false;

    public void attach(Observer o){
        observes.add(o);
    }

    public void detach(Observer o){
        observes.remove(o);
    }

    protected void notifyObservers(){
        for (Observer o : observes){
            o.update();
        }
        this.state = false;
    }

    public void setState(boolean s){
        this.state = s;
        notifyObservers();
    }


}
