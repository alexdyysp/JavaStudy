package com.Study.DesignPattern.StrategyPattern;

public class WildDuck extends Duck{
    public WildDuck(){
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("wild duck");
    }

    @Override
    public void quack() {
        super.quack();
    }

    @Override
    public void swim() {
        super.swim();
    }

    @Override
    public void fly() {
        super.fly();
    }
}
