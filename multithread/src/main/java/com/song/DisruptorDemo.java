package com.song;

import com.lmax.disruptor.dsl.Disruptor;

/**
 * 1、声明Event来包含需要传递的数据
 * 2、使用EventFactory来实例化event
 * 3、消费处理事件
 * 4、生产者发送事件
 */
public class DisruptorDemo {
    private final Disruptor<StringEvent> disruptor;

    public DisruptorDemo(Disruptor<StringEvent> disruptor) {
        this.disruptor = disruptor;
        // 链接消费的方式
        this.disruptor.handleEventsWith(new StringEventHandler());
        // 启动
        disruptor.start();
    }


}
