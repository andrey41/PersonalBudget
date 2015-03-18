/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.gr41.PersonalBudget.model;

import java.util.ArrayList;

/**
 *
 * @author Andrey
 */
public class Series {
    ArrayList<String> name;
    ArrayList<Double> data;
    
    public Series()
    {
        name=new ArrayList<String>();
        data=new ArrayList<Double>();
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<Double> getData() {
        return data;
    }

    public void setData(ArrayList<Double> data) {
        this.data = data;
    }
    
    
    
}
