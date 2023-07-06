package com.example.progetto_ispw.saveHoursSlots;

import com.example.progetto_ispw.saveHoursSlots.exception.InvalidTimeException;
import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHoursBean {
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    private String dateCalendar;
    private static final Pattern VALID_SLOT_HOURS_REGEX = Pattern.compile("^([01]?\\d|2[0-3]):([0-5]?\\d)$", Pattern.CASE_INSENSITIVE);
    private String email;


    public void setSlot1(String text1) throws InvalidTimeException {
        Matcher matcher = VALID_SLOT_HOURS_REGEX.matcher(text1);
        if (!matcher.find()) {
            throw new InvalidTimeException("Invalid time form Slot1, try again!");
        }
        this.text1 = text1;

    }

    public void setSlot2(String text2) throws InvalidTimeException {
        Matcher matcher = VALID_SLOT_HOURS_REGEX.matcher(text2);
        if (!matcher.find())
            throw new InvalidTimeException("Invalid time form Slot2, try again!");
        this.text2 = text2;
    }

    public void setSlot3(String text3) throws InvalidTimeException {
        Matcher matcher = VALID_SLOT_HOURS_REGEX.matcher(text3);
        if (!matcher.find())
            throw new InvalidTimeException("Invalid time form Slot3, try again!");
        this.text3 = text3;
    }

    public void setSlot4(String text4) throws InvalidTimeException{
        Matcher matcher = VALID_SLOT_HOURS_REGEX.matcher(text4);
        if (!matcher.find())
            throw new InvalidTimeException("Invalid time form Slot4, try again!");
        this.text4 = text4;
    }

    public void setSlot5(String text5) throws InvalidTimeException{
        Matcher matcher = VALID_SLOT_HOURS_REGEX.matcher(text5);
        if (!matcher.find())
            throw new InvalidTimeException("Invalid time form Slot5, try again!");
        this.text5 = text5;
    }
    //controllare se va bene
    public void setDateCalendar(String dateCalendar, String sslot1, String sslot2, String sslot3, String sslot4, String sslot5) throws TimeSlotAlreadyExistsException {
        //prova per vedere se due slot uguali nella stessa data siano un problema
       /* SlotHoursEntity shEntity= new SlotHoursEntity();
        String slot1= shEntity.getSlot1();
        String slot2= shEntity.getSlot2();
        String slot3= shEntity.getSlot3();
        String slot4= shEntity.getSlot4();
        String slot5= shEntity.getSlot5();
        String date=  shEntity.getdate() ;

        System.out.println(date);
        System.out.println("1 "+slot1);
        System.out.println("2 "+slot2);
        System.out.println("3 "+slot3);
        System.out.println("4 "+slot4);
        System.out.println("5 "+slot5);

        if (date.equals(dateCalendar) &&
                (slot1.equals(sslot1)|
                        slot1.equals(sslot2)|
                        slot1.equals(sslot3)|
                        slot1.equals(sslot4)|
                        slot1.equals(sslot5)|

                        slot2.equals(sslot1)|
                        slot2.equals(sslot2)|
                        slot2.equals(sslot3)|
                        slot2.equals(sslot4)|
                        slot2.equals(sslot5)|

                        slot3.equals(sslot1)|
                        slot3.equals(sslot2)|
                        slot3.equals(sslot3)|
                        slot3.equals(sslot4)|
                        slot3.equals(sslot5)|

                        slot4.equals(sslot1)|
                        slot4.equals(sslot2)|
                        slot4.equals(sslot3)|
                        slot4.equals(sslot4)|
                        slot4.equals(sslot5)|

                        slot5.equals(sslot1)|
                        slot5.equals(sslot2)|
                        slot5.equals(sslot3)|
                        slot5.equals(sslot4)|
                        slot5.equals(sslot5)
                )
        ){throw new TimeSlotAlreadyExistsException("Lo slot selezione è già esistente");

        }

        //fine prova


*/
        this.dateCalendar = dateCalendar;

    }

    //fino a qui
    public void setemail(String email) {
        this.email= email;
    }

    public String getSlot1() {
        return text1;
    }
    public String getSlot2() {
        return text2;
    }
    public String getSlot3() {
        return text3;
    }
    public String getSlot4() {
        return text4;
    }

    public String getSlot5() {
        return text5;
    }

    public String getDateCalendar() {
        return dateCalendar;
    }

    public String getemail() {
    return email;}
}
