package com.Study.DesignPattern.StrategyPattern;

public class ToyDuck extends Duck {
    public ToyDuck(){
        flyBehavior = new Notflybehavior();
    }

    @Override
    public void display(){
        System.out.println("toy duck");
    }

    @Override
    public void quack(){
        System.out.println("toy cannot quack");
    }

    @Override
    public void swim(){
        System.out.println("toy cannot swim");
    }
}
