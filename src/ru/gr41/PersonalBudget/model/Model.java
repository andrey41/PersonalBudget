/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.gr41.PersonalBudget.model;

/**
 *
 * @author VLad
 */
public class Model {
    Operations rashod;
    Operations dohod;
    int currentDay;
    int currentMonth;
    int currentYear;
    double balance;
    public Model(int day,int month,int year)
    {
        rashod=new Operations("rashod");
        dohod=new Operations("dohod");
        currentDay=day;
        currentMonth=month;
        currentYear=year;
        balance=0;
    }
    public void setCurrentDate(int day,int month,int year)
    {
        currentDay=day;
        currentMonth=month;
        currentYear=year;
    }
    public void calculateBalance()
    {
        balance=dohod.totalSumForCurrentMonth-rashod.totalSumForCurrentMonth;
    }
    public void updateModel()
    {
        
        rashod.calculateTotalSumForCurrentMonth(currentMonth);
        rashod.calculateTotalSumForCurrentMonth(currentMonth);
        calculateBalance();
    }
    

    
    
}
