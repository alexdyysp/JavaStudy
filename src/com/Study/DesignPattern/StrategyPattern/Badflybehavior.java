package com.Study.DesignPattern.StrategyPattern;

public class Badflybehavior implements FlyBehavior {

    @Override
    public void fly(){
        System.out.println("fly just so so");
    }
}
