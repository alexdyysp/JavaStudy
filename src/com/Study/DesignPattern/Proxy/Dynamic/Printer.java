package com.Study.DesignPattern.Proxy.Dynamic;

public class Printer implements IPrinter {
    public void print(String message) {
        System.out.println("Printer print" + message);
    }
}
