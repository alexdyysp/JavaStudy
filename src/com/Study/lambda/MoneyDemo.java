package com.Study.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

//interface ImoneyFormat{
//    String format(int i);
//}

class MyMoney{
    private final int money;

    public MyMoney(int money){
        this.money = money;
    }

    public void printMoney(Function<Integer, String> moneyFormat){
        System.out.println("My account has: " + moneyFormat.apply(this.money));
    }
}
public class MoneyDemo {
    public static void main(String[] args){
        MyMoney me = new MyMoney(999);

        me.printMoney(i -> new DecimalFormat("#,###").format(i));

        Function<Integer, String > moneyF = i->new DecimalFormat("#,###").format(i);

        // 函数接口链式操作
        me.printMoney(moneyF.andThen(s->"chain"+s));
    }
}
