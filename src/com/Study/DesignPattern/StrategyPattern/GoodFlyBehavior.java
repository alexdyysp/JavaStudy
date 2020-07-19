package com.Study.DesignPattern.StrategyPattern;

public class GoodFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("fly very well");
    }
}
