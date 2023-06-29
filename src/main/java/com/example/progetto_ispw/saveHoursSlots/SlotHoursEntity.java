package com.example.progetto_ispw.saveHoursSlots;

public class SlotHoursEntity {
    private String email;
    private String slot1;
    private String slot2;
    private String slot3;
    private String slot4;
    private String slot5;
    private String dateCalendar;

    public void setEmail(String email) {
        this.email= email;
    }

    public void setSlot1(String slot1) {
        this.slot1=slot1;
    }

    public void setSlot2(String slot2) {
        this.slot2=slot2;
    }

    public void setSlot3(String slot3) {
        this.slot3=slot3;
    }

    public void setSlot4(String slot4) {
        this.slot4=slot4;
    }

    public void setSlot5(String slot5) {
        this.slot5=slot5;
    }

    public void setDateCalendar(String dateCalendar) {
        this.dateCalendar=dateCalendar;
    }


    public String  getSlot1(){return slot1;}
    public String  getSlot2(){return  slot2;}
    public String  getSlot3(){return  slot3;}
    public String  getSlot4(){return  slot4;}
    public String  getSlot5(){return  slot5;}
    public String  getemail(){return  email;}
    public String date(){return  dateCalendar;}



}
