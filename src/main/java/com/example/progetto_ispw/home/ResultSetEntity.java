package com.example.progetto_ispw.home;

import com.sun.glass.ui.Clipboard;

import java.util.ArrayList;
import java.util.List;

public class ResultSetEntity {
    private ArrayList<ResultElement> elementsList = new ArrayList<>();
    public void addElement(ResultElement r) {

        elementsList.add(r);
    }

public List<ResultElement> getElements(){return this.elementsList;}

public void setElementsList(List<ResultElement> elementsList){
        this.elementsList = (ArrayList<ResultElement>)  elementsList;
}

}
