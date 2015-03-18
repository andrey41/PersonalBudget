/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.gr41.PersonalBudget.model;

/**
 *
 * @author Andrey
 */
public class Record {
    int day;
    int month;
    int year;
    double sum;

    public Record(int day, int month, int year, double sum) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.sum = sum;
    }
    public String getDate()
    {
        String s=""+day+"."+month+"."+year;
        return s;
    }
    
    
}
