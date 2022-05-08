package com.atguigu.observer;

public class LiSi implements Observer {
    public void update(String context) {
        System.out.println("李斯：观察到韩非子的行动啦！开始汇报老板。。。");
        reportToQinShiHuang(context);
    }
    private void reportToQinShiHuang(String reportContext){
        System.out.println("李斯报告老板，韩非子有活动了！---》"+ reportContext);
    }
}
