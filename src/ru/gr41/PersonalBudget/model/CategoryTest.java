package ru.gr41.PersonalBudget.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CategoryTest extends TestCase {

    ArrayList<Record> records;
    String name;
    double sumForCurrentMonth;


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
    public double calculateSumForMonth(int month)
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
        return s;
    }


    @Test

    public void testDelRecord() {
        int index=2;
        int records = 2;
        addRecord(20,5,2015,3000);
        addRecord(21,5,2015,2000);
        delRecord(index);
        if(index<records)
            System.out.println("Removed");
        else System.out.println("not removed");
    }


    public void testCalcSomMonth() {
        addRecord(20,5,2015,3000);
        addRecord(21,5,2015,2000);
        double s=calculateSumForMonth(5);
        if(s!=5000)
            fail("Not equals");
    }

}


