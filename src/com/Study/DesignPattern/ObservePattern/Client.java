package com.Study.DesignPattern.ObservePattern;

public class Client {

    public static void main(String[] args){
        PlayerGround playerGround = new PlayerGround();
        PlayerA playerA = new PlayerA();
        PlayerB playerB = new PlayerB();

        int allTime = 100;
        System.out.println("总时间是");
        System.out.println(playerGround.getTime());

        playerGround.OnPlayer(playerA);
        while (allTime>0){
            if(allTime == 50) playerGround.OnPlayer(playerB);
            if(allTime == 10) playerGround.OffPlayer(playerA);
            playerGround.notifiy();
            allTime--;
        }

        System.out.println("计时结束：");
        System.out.println(playerGround.getTime());
        System.out.println(playerA.getOnTime());
        System.out.println(playerB.getOnTime());
    }



}
