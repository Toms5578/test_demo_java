package com.song;

import com.lmax.disruptor.EventHandler;

public class StringEventHandler implements EventHandler<StringEvent> {

    /**
     * 消费者处理器
     * @param stringEvent
     * @param l
     * @param b
     * @throws Exception
     */
    public void onEvent(StringEvent stringEvent, long l, boolean b) throws Exception {
        System.out.println("消费者"+stringEvent.getValue()+" "+l);
    }
}
