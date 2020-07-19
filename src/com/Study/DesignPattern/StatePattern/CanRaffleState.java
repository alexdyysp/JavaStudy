package com.Study.DesignPattern.StatePattern;

import java.util.Random;

/**
 * ���Գ齱��״̬
 * @author Administrator
 *
 */
public class CanRaffleState extends State {

    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    //已扣除积分不能再扣
    @Override
    public void deductMoney() {
        System.out.println("已扣积分");
    }

    //可抽奖，根据情况改状态
    @Override
    public boolean raffle() {
        System.out.println("抽奖中");
        Random r = new Random();
        int num = r.nextInt(10);
        // 10%中奖
        if(num == 0){
            // 改变状态为发奖
            activity.setState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("没中奖");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRafflleState());
            return false;
        }
    }

    // 不能发奖
    @Override
    public void dispensePrize() {
        System.out.println("没中奖");
    }
}
