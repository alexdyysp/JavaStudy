package com.Study.DesignPattern.ObservePattern;

public interface Subject {

    public void OnPlayer(Observer obs);
    public void OffPlayer(Observer obs);
    public void notifiy();

}
