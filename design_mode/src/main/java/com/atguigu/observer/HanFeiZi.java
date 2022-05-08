package com.atguigu.observer;

import java.util.ArrayList;

public class HanFeiZi implements IHanFeiZi,Observable {

    private boolean isHaveBreakfast = false;



    private boolean isHaveFun = false;

    public void haveBreakfast() {
        System.out.println("韩非子开始吃饭");
        isHaveBreakfast = true;

    }

    public void haveFun() {

        System.out.println("韩非子开始娱乐");
        isHaveFun = true;
    }
    public boolean isHaveBreakfast() {
        return isHaveBreakfast;
    }

    public boolean isHaveFun() {
        return isHaveFun;
    }

    public void setHaveBreakfast(boolean haveBreakfast) {
        isHaveBreakfast = haveBreakfast;
    }

    public void setHaveFun(boolean haveFun) {
        isHaveFun = haveFun;
    }

    private ArrayList<Observer> observables = new ArrayList<Observer>();
    /**
     * 增加观察者
     * @param
     */
    public void addObserver(Observer observer) {
        observables.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observables.remove(observer);
    }

    public void notifyObservers(String context) {
        for (Observer observable : observables) {
            observable.update(context);
        }
    }
}
