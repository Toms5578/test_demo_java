package com.atguigu.observer;

public interface Observable {
    // 添加观察者
    public void addObserver(Observer observer);
    // 删除观察者
    public void deleteObserver(Observer observer);
    //既然是观察者则，发生变化就要做出改变
    public void notifyObservers(String context);
}
