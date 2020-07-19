package com.Study.DesignPattern.StatePattern;

/**
 * ״̬ģʽ������
 * @author Administrator
 *
 */
public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建活动对象，仅1个奖品
        RaffleActivity activity = new RaffleActivity(1);

        // 连续抽300词
        for (int i = 0; i < 10; i++) {
            System.out.println("--------第" + (i + 1) + "次----------");
            // 先扣积分
            activity.debuctMoney();

            // 再抽奖
            activity.raffle();
        }
	}

}
