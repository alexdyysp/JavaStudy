package com.stackoverflow.q20200806;

public abstract class Hire {
    //Private field of type vehicle to store the vehicle on hire
    //Private int to store the duration of hire in days
    private int days;
    private String vehicle;

    private int dailyCost;
    //Need to declare this field properly later
    private Vehicle aVehicle;

    // a blank Constructor
    public Hire(){

    }

    //Constructor for the Hire with two fields and two parameters
    public Hire(String vehicle, int days) {
        this.vehicle = aVehicle.getModelname();
        this.days = days;
    }

    //Getter for model days
    public int getDays() {
        return days;
    }

    //Setter for model days
    public void setdays() {
        this.days = days;
    }

    //Getter for model vehicle
    public String getVehicle() {
        return vehicle;
    }

    //Setter for model vehicle
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle.getModelname();
    }

    //Method to calculate the total cost of hire
    public double getCost(){
        return (days * dailyCost);
    }


    //Think this is in the right place?
    @Override
    //Method to return the details of Hire as a string
    public String toString(){
        String result = ("Vehicle: " + this.aVehicle.getModelname()+ this.dailyCost + " per day. Days: " + this.getDays() + " Hire Cost: " + this.getCost() );
        return result;
    }


}
