package com.Study.DesignPattern.StrategyPattern;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class PekingDuck extends Duck {
    public PekingDuck(){
        flyBehavior = new Badflybehavior();
    }

    @Override
    public void display(){
        System.out.println("peiking duck");
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
