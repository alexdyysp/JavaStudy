package com.Study.DesignPattern.Proxy.Staic;

public class PrinterProxy implements Print{

    public void printMessage(String message) {
        System.out.println("log write");
        System.out.println(message);
    }

}
