package com.atguigu.observer;

public class Spy extends Thread {

    private IHanFeiZi hanFeiZi;
    private Observer liSi;
    private String type;
    public Spy(IHanFeiZi hanFeiZi, Observer liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }


    @Override
    public void run() {
        // 监控任务


    }
}
