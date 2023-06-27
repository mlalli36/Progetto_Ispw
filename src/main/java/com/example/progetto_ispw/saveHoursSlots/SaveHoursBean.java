package com.example.progetto_ispw.saveHoursSlots;

import com.example.progetto_ispw.saveHoursSlots.exception.InvalidTimeException;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHoursBean {
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    private DatePicker dateCalendar;
    private static final Pattern VALID_SLOT_HOURS_REGEX = Pattern.compile("^([01]?\\d|2[0-3]):([0-5]?\\d)$", Pattern.CASE_INSENSITIVE);


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
        Matcher matcher = VALID_SLOT_HOURS_REGEX.matcher(text4);
        if (!matcher.find())
            throw new InvalidTimeException("Invalid time form Slot5, try again!");
        this.text5 = text5;
    }
    //controllare se va bene
    public void setDateCalendar(TextField dateCalendar) {
        this.dateCalendar = dateCalendar;
    }
    //fino a qui

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


    public DatePicker getDateCalendar() {
        return dateCalendar;
    }
}
