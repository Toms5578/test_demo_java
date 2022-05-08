package demo.test;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 */
public class ExecutorService {


   static class Executor
    {
        private final String name;
        private static final AtomicLong seqids = new AtomicLong(0);
        private final long id;

        public Executor(String name, long maxThreads) {
            this.name = name;
            this.id = seqids.incrementAndGet();
        }
    }



}
