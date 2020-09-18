package com.stackoverflow.q20200916;

import java.util.Arrays;

/**
 * @Author daiyuanyang
 * @Date 2020/9/16 10:36 下午
 */
public class DecentJob{

    public static class B {}
    public static class C {}
    public static class D {}
    B b;
    C c;
    D d;

    public DecentJob(B b, C c, D d) {
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Class<?> getValueType() {
        DecentJob me=this;
        try {
            return Arrays.stream(this.getClass().getDeclaredFields()).filter(field->{
                try {
                    return field.get(me)!=null;
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    return false;
                }
            }).findAny().get().get(me).getClass();
        } catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String args[])
    {
        System.out.println(new DecentJob(new B(), new C(),null).getValueType());
        System.out.println(new DecentJob(null,new C(),null).getValueType());
        System.out.println(new DecentJob(null,null,new D()).getValueType());
    }
}
