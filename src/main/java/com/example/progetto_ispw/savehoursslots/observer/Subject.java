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

        /*private List<Observer> observes = new ArrayList<>();

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

*/


}
