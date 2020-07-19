package com.Study.DesignPattern.StrategyPattern;

public abstract class Duck {
    // 属性策略接口
    FlyBehavior flyBehavior;
    // 默认策略接口
    Quackbehavior quackbehavior;

    public Duck(){}

    public abstract void display();

    public void quack(){
        System.out.println("duck: gagaga...");
    }

    public void swim(){
        System.out.println("duck: swimswimswim...");
    }

    public void fly(){
        if(flyBehavior!=null) flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackbehavior(Quackbehavior quackbehavior){
        this.quackbehavior = quackbehavior;
    }
}
