package com.example.progetto_ispw.searchDinamica;

import com.example.progetto_ispw.home.ResultSetEntity;

import java.util.List;

public class SearchDinamicaBean {

    private ResultSetEntity resultSet;
    private String emailsearch;


    public void setResultSet(ResultSetEntity resultSet) {
        this.resultSet= resultSet;
    }

    public ResultSetEntity getResultSet(){
        return resultSet;
    }

    public void setEmail(String emailsearch) {this.emailsearch= emailsearch;}

    public String getemailsearch() {return emailsearch;}
}
