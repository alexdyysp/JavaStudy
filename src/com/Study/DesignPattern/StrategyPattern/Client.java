package com.Study.DesignPattern.StrategyPattern;

public class Client {
    public static void main(String[] args){

        WildDuck wildDuck = new WildDuck();
        ToyDuck toyDuck = new ToyDuck();
        PekingDuck pekingDuck = new PekingDuck();

        wildDuck.fly();
        toyDuck.fly();
        pekingDuck.fly();

        pekingDuck.setFlyBehavior(new Notflybehavior());
        pekingDuck.fly();

    }
}
