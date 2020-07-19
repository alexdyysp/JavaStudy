package com.Study.DesignPattern.ObservePattern;

public class PlayerA implements Observer {

    private int onTime = 0;

    @Override
    public void updateOnGround(){
        onTime++;
    }

    public int getOnTime(){
        return onTime;
    }
}
