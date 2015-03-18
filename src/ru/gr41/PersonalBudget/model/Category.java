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
//test!
public class Category {
    ArrayList<Record> records;
    String name;
    double sumForCurrentMonth;
    
    public Category(String name) {
        this.name = name;
        records=new ArrayList<Record>();
        sumForCurrentMonth=0;
    }
    
    public void addRecord(int day,int month,int year,double sum)
    {
        records.add(new Record(day, month, year, sum));
    }
    public void delRecord(int index)
    {
        if (index<records.size())
        {
            records.remove(index);
        }
    }
    public void calculateSumForMonth(int month)
    {
        double s=0;
        Record r;
        for (int i=records.size()-1;i>-1;i--)
        {
            r=records.get(i);
            if (r.month==month)
            {
                 s+=records.get(i).month;
            }
        }
        sumForCurrentMonth=s;
    }
    public int getRecordsCountInChoosenMonth(int month)
    {
        int size=0;
        Record r;
        for (int i=records.size()-1;i>-1;i--)
        {
            r=records.get(i);
            if (r.month==month)
            {
                 size+=records.get(i).month;
            }
        }
       return size;
    }
    
    
    
    
}
