package com.example.progetto_ispw.searchDinamica;

import com.example.progetto_ispw.home.ResultSetEntity;

import java.util.List;

public class SearchDinamicaBean {
    private List<String> workerList =null;
    private ResultSetEntity resultSet;

    public void setResultList(List<String> workerList) { this.workerList=workerList ;}


    public List<String> getResultList() {
        return workerList;
    }
    public void setResultSet(ResultSetEntity resultSet) {
        this.resultSet= resultSet;
    }

    public ResultSetEntity getResultSet(){ return resultSet;}
}
