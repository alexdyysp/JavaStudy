package com.Study.DesignPattern.Proxy.Dynamic;

public class Client {
    public static void main(String[] args){
        ProxyHandler proxyHandler = new ProxyHandler();
        IPrinter printer = (IPrinter) proxyHandler.newProxyInstance(new Printer());
        printer.print("123");
    }
}
