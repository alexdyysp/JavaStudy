package com.Study.DesignPattern.StrategyPattern;

public class Notflybehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("can not fly");
    }
}
