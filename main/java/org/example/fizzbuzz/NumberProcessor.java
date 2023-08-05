package org.example.fizzbuzz;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class NumberProcessor extends Thread {
    private Consumer<Integer> processor;
    private int n;
    private int finishNumber;
    private AtomicBoolean isProcessed = new AtomicBoolean(true);

    public NumberProcessor(Consumer<Integer> processor, int finishNumber) {
        this.processor = processor;
        this.finishNumber = finishNumber;
    }

    public boolean isNProcessed() {
        return isProcessed.get();
    }

    public void process(int n) {
        this.n = n;
        isProcessed.set(false);
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if (isProcessed.get()) {
                if (n == finishNumber) {
                    break;
                }
                continue;
            }

            processor.accept(n);
            isProcessed.set(true);
        }
    }
}
