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
public class Operations {
    ArrayList<Category> categories;
    double totalSumForCurrentMonth;
    String name;
    
    public Operations(String name)
    {
        this.name=name;
        totalSumForCurrentMonth=0;
        categories=new ArrayList<Category>();
    }
    
    public void addCategory(String name)
    {
        categories.add(new Category(name));
    }
    
    public void delCategory(int index)
    {
        if (index<categories.size())
        {
            categories.remove(index);
        }
    }
    
    public void calculateTotalSumForCurrentMonth(int month)
    {
        totalSumForCurrentMonth=0;
        for (Category c : categories) {
            c.calculateSumForMonth(month);
            totalSumForCurrentMonth+=c.sumForCurrentMonth;
        }
    }
    public void updateCategories(int month)
    {
        for (int i=0;i<categories.size();i++)
        {
            categories.get(i).calculateSumForMonth(month);
        }
        calculateTotalSumForCurrentMonth(month);
    }
    public void updateCategory(int index,int month)
    {
        Category c=categories.get(index);
        c.calculateSumForMonth(month);
        calculateTotalSumForCurrentMonth(month);
        
    }
    
    
}
