package com.Study.DesignPattern.Proxy.Staic;

public class Clent {
    public static void main(String[] args){
        PrinterProxy printer = new PrinterProxy();
        printer.printMessage("test");
    }
}
