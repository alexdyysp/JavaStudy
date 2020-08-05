package com.stackoverflow.q20200806;

public class Test {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle("Driver",100);
        Hire hire = new Hire() {
            @Override
            public int getDays() {
                return super.getDays();
            }

            @Override
            public void setVehicle(Vehicle vehicle) {
                super.setVehicle(vehicle);
            }

            @Override
            public String getVehicle() {
                return super.getVehicle();
            }
        };

        hire.setVehicle(vehicle);
        System.out.println("Vehivle Class Name: " + vehicle.getModelname());

        System.out.println("Abstract Hire Class Name: " + hire.getVehicle());
    }
}
