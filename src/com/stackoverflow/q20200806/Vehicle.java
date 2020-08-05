package com.stackoverflow.q20200806;

public class Vehicle {

    //Private string field that stores the name of the vehicle
    //Private double field that stores the cost per day for vehicle hire
    private String modelName;
    private double dailyCost;

    //Constructor for vehicle with two fields using two parameters
    public Vehicle(String Modelname, double dailyCost) {
        this.modelName = Modelname;
        this.dailyCost = dailyCost;
    }

    //Getter for model name
    public String getModelname() {
        return modelName;
    }

    //Setter for model name
    public void setModelName() {
        this.modelName = modelName;
    }

    //Getter for daily cost
    public double getDailyCost() {
        return dailyCost;
    }

    //Setter for daily cost
    public void setDailyCost() {
        this.dailyCost = dailyCost;
    }

    @Override
    //Return details as formatted String
    public String toString(){
        String result = "Vehicle: " + this.getModelname()+ " £" + this.getDailyCost() + " per day\n";
        return result;
    }



}

