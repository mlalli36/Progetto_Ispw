package com.example.progetto_ispw.home;

import com.sun.glass.ui.Clipboard;

import java.util.ArrayList;

public class ResultSetEntity {
    private ArrayList<ResultElement> elementsList = new ArrayList<>();
    public void addElement(ResultElement r) {

        elementsList.add(r);
    }
}
