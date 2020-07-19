package com.Study.DesignPattern.StatePattern;

/**
 * ���Ž�Ʒ��״̬
 * @author Administrator
 *
 */
public class DispenseState extends State {

	 // 初始化
    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }
    
    //

    @Override
    public void deductMoney() {
        System.out.println("无法扣分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    //���Ž�Ʒ
    @Override
    public void dispensePrize() {
        if(activity.getCount() > 0){
            System.out.println("中奖了");
            // 奖品发完，不能再抽
            activity.setState(activity.getNoRafflleState());
        }else{
            System.out.println("奖品发完了");
            // 奖品送完
            activity.setState(activity.getDispensOutState());
            //System.out.println("活动结束");
            //System.exit(0);
        }

    }
}
