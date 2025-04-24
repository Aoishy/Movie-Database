package com.example.demo12;

import java.io.Serializable;

public class Movie implements Serializable {
    String Title;
    int Year;
    String Genre1;
    String Genre2;
    String Genre3;

    String Production_Company;
    long Budget;
    long Revenue;
    int Running_Time;

    public long getRevenue() {
        return Revenue;
    }

    public int getRunning_Time() {
        return Running_Time;
    }

    public void setRunning_Time(int running_Time) {
        Running_Time = running_Time;
    }

    public void setRevenue(long revenue) {
        Revenue = revenue;
    }

    public int getYear() {
        return Year;
    }

    public long getBudget() {
        return Budget;
    }

    public void setBudget(long budget) {
        Budget = budget;
    }

    public String getProduction_Company() {
        return Production_Company;
    }

    public void setProduction_Company(String production_Company) {
        Production_Company = production_Company;
    }

    public String getGenre3() {
        return Genre3;
    }

    public void setGenre3(String genre3) {
        Genre3 = genre3;
    }

    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public void setGenre2(String genre2) {
        Genre2 = genre2;
    }

    public void setGenre1(String genre1) {
        Genre1 = genre1;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Movie(String Title, int Year, String Genre1, String Genre2, String Genre3, int Running_Time, String Production_Company, long Budget, long Revenue) {
        this.Title=Title;
        this.Year=Year;
        this.Genre1=Genre1;
        this.Genre2=Genre2;
        this.Genre3=Genre3;
        this.Running_Time=Running_Time;
        this.Production_Company=Production_Company;
        this.Budget=Budget;
        this.Revenue=Revenue;


    }



}
