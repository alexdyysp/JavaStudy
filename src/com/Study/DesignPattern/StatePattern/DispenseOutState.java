package com.Study.DesignPattern.StatePattern;

/**
 * ��Ʒ�������״̬
 * ˵����������activity �ı�� DispenseOutState�� �齱�����
 * @author Administrator
 *
 */
public class DispenseOutState extends State {

	// 初始化时，传入活动引用
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("奖品发完了");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发完了");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发完了");
    }
}
