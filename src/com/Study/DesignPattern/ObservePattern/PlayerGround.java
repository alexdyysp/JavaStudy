package com.Study.DesignPattern.ObservePattern;

import java.util.ArrayList;

public class PlayerGround implements Subject{

    private int Time = 0;
    private ArrayList<Observer> players;

    public PlayerGround(){
        players = new ArrayList<Observer>();
    }

    public void updateTime(){
        Time ++;
    }

    public int getTime(){
        return Time;
    }

    @Override
    public void OnPlayer(Observer obs) {
        players.add(obs);
    }

    @Override
    public void OffPlayer(Observer obs) {
        if(players.contains(obs))
            players.remove(obs);
        else
            System.out.println("the players is already off");
    }

    @Override
    public void notifiy() {
        for(int i=0; i<players.size(); i++){
            players.get(i).updateOnGround();
        }
    }
}
