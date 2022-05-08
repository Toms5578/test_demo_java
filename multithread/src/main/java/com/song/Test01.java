package com.song;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

public class Test01 {

    public static void main(String[] args) {
        Disruptor<StringEvent> stringEventDisruptor = new Disruptor<>(StringEvent::new, 16,
                Executors.defaultThreadFactory(), ProducerType.MULTI, new YieldingWaitStrategy());

        DisruptorDemo disruptorDemo = new DisruptorDemo(stringEventDisruptor);


    }


}
