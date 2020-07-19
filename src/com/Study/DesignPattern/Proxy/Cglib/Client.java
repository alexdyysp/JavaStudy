package com.Study.DesignPattern.Proxy.Cglib;

import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args){
        // get object by cglib dynamic proxy
        Enhancer enhancer = new Enhancer();

        // 设置目标类字节码
        enhancer.setSuperclass(UserDao.class);
        // 设置回调函数
        enhancer.setCallback(new LogInterceptor());
        // create方法创建代理类
        UserDao userDao = (UserDao) enhancer.create();

        userDao.findAllUsers();
        userDao.findUsernameById(1);
    }
}
