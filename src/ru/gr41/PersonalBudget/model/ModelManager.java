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
public class ModelManager {
    Model model;
    Category currentCategory;
    Operations currentFinObj;
    
    public ModelManager(Model m)
    {
        model=m;
    }
    //main screen(1)
    public String getCurrentDate()
    {
        String s="";
        s+=model.currentDay+".";
        s+=""+model.currentMonth+".";
        s+=""+model.currentYear;
        return s;
    }
    
    public double getBalance()
    {
        return model.balance;
    }
    public double getDohodForCurrentMonth()
    {     
        return model.dohod.totalSumForCurrentMonth;
    }
    public double getRashodForCurrentMonth()
    {     
        return model.rashod.totalSumForCurrentMonth;
    }
    public void chooseFinObj(int i)//1-rashod else dohod
    {
        if (i==1) currentFinObj=model.rashod;
        else currentFinObj=model.dohod;
    }
    //Categories screen(2 r/d)
    public String getNameForCurrentFinObj()
    {
        return currentFinObj.name;
    }
   /* public double getResidueOfLastMonth(int currentMonth)
    {
        
    }*/
    public double getTotalSumForCurrentFinObjForCurrentMonth()
    {
        return currentFinObj.totalSumForCurrentMonth;
    }
    public int getCategoriesCountForCurrentFinObj()
    {
        return currentFinObj.categories.size();
    }
    public String getCategoryNameForCurrentFinObj(int index)
    {
        return currentFinObj.categories.get(index).name;
    }
    public double getCategorySumForCurrentFinObjForCurrentMonth(int index)
    {
        return currentFinObj.categories.get(index).sumForCurrentMonth;
    }
     
    public void delCategoryForCurrentFinObj(int index)
    {
        currentFinObj.delCategory(index);
        currentFinObj.updateCategories(model.currentMonth);
    }
    public void addCategoryForCurrentFinObj(String name)
    {
        currentFinObj.addCategory(name);
    }
    public void chooseCategoryForCurrentFinObj(int index)
    {
        currentCategory=currentFinObj.categories.get(index);
    }
    //Records screen (3 d/r)
    public String getCurrentCategoryName()
    {
        return currentCategory.name;
    }
    public int getRecordsCountForCurrentCategoryForCurrentMonth()
    {
       return currentCategory.getRecordsCountInChoosenMonth(model.currentMonth);
    }
    public String getRecordsDateForCurrentCategory(int index)
    {
        int recordsInMonth=getRecordsCountForCurrentCategoryForCurrentMonth();
        int tekInd=currentCategory.records.size()-recordsInMonth;
        return currentCategory.records.get(tekInd+index).getDate();
    }
    public double getRecordsSumForCurrentCategory(int index)
    {
        int recordsInMonth=getRecordsCountForCurrentCategoryForCurrentMonth();
        int tekInd=currentCategory.records.size()-recordsInMonth;
        return currentCategory.records.get(tekInd+index).sum;
    }
    public void addRecordForCurrentCategory(double sum)
    {
        currentCategory.addRecord(model.currentDay, model.currentMonth, model.currentYear, sum);
        model.updateModel();
    }
    public void delRecordForCurrenCategory(int index)
    {
        currentCategory.delRecord(index);
        model.updateModel();
    }
    public void showPage1()
    {
        System.out.println("page 1");
        System.out.println(getCurrentDate());
        System.out.println(getBalance());
        System.out.println("dohod "+getDohodForCurrentMonth());
        System.out.println("rashod "+getRashodForCurrentMonth());
        
    }
    public void showPage2(int i)
    {
        chooseFinObj(i);
        System.out.println(getNameForCurrentFinObj());
        System.out.println(getTotalSumForCurrentFinObjForCurrentMonth());
        for (int j=0;j<getCategoriesCountForCurrentFinObj();j++)
        {
            System.out.println(getCategoryNameForCurrentFinObj(j)+" "+getCategorySumForCurrentFinObjForCurrentMonth(j));
        }
        
    }
    
    public void showPage3(int i,int j)
    {
        chooseFinObj(i);
        chooseCategoryForCurrentFinObj(j);
        System.out.println(getCurrentCategoryName());
        for (int k=0;k<getRecordsCountForCurrentCategoryForCurrentMonth();j++)
        {
            System.out.println(getRecordsDateForCurrentCategory(j)+" "+getRecordsSumForCurrentCategory(j));
        }
    }
    /*//Statistic (4)
    public Series getRashodPoCategoriamForDay()
    {
        
    }
    public Series getRashodPoCategoriamForMonth()
    {
        
    }
    public Series getRashodPoCategoriamForYear()
    {
        
    }
    public Series getDohodPoCategoriamForDay()
    {
        
    }
    public Series getDohodPoCategoriamForMonth()
    {
        
    }
    public Series getDohodPoCategoriamForYear()
    {
        
    }
    */
}
