package com.stackoverflow.q20200724;

public class Date {
    int year;
    String month;
    int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date() {

    }

    public Date(int year, String month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDateString()
    {
        String dob = String.valueOf(day) +" "+ month +" "+ String.valueOf(year);
        return dob;
    }
}
