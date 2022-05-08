package com.song;

import com.lmax.disruptor.RingBuffer;

public class StringEventProducer {

    private final RingBuffer<StringEvent> ringBuffer;

    public StringEventProducer(RingBuffer<StringEvent> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    public void onData(String data)
    {
        //1、获取空的位置
        long next = ringBuffer.next();

        try {
            //2、取空的事件队列
            StringEvent stringEvent = ringBuffer.get(next);
            //3、获取事件传递的数据
            stringEvent.setValue(data);
        }
        finally
        {
            // 4、发布数据
            ringBuffer.publish(next);
        }


    }
}
