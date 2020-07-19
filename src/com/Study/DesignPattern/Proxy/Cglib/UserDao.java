package com.Study.DesignPattern.Proxy.Cglib;

public class UserDao {

    public void findAllUsers(){
        System.out.println("UserDao 查询所有用户");
    }

    public String findUsernameById(int id){
        System.out.println("UserDao 根据ID查询用户" + String.valueOf(id));
        return "查询完成";
    }

}
