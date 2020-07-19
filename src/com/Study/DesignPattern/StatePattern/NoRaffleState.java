package com.Study.DesignPattern.StatePattern;

/**
 * ���ܳ齱״̬
 * @author Administrator
 *
 */
public class NoRaffleState extends State {

	 // 初始化
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    // 扣分，设置为可抽奖状态
    @Override
    public void deductMoney() {
        System.out.println("扣50积分，可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    // 不能抽奖
    @Override
    public boolean raffle() {
        System.out.println("先扣积分才能抽奖");
        return false;
    }

    // 不能发奖
    @Override
    public void dispensePrize() {
        System.out.println("不能发奖品");
    }
}
