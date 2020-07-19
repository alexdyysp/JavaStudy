package com.question.UpDownCasting;

public class Car extends Vehicle {

    protected String name = "car";

    public static void main(String[] args){
        Vehicle vehicle = new Car();
        System.out.println(vehicle.name+ " ");
        // 此处将调用子类的run()方法。
        // 原因：vehicle实际指向的是Car子类，故调用时会调用子类本身的方法。
        vehicle.run();

        Car car = (Car) vehicle;
        System.out.println(car.name+ " ");
        car.run();
        car.stop();
    }

    public void run(){
        System.out.println("car run");
    }

    public void stop(){
        System.out.println("car stop");
    }
}
