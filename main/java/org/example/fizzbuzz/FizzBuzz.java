package org.example.fizzbuzz;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public BlockingQueue<String> getQueue() {
        return queue;
    }
    public void fizz(int n) {
        if (n % 3 == 0) {
            queue.add("fizz");
            //System.out.println("fizz");
        }
    }

    public void buzz(int n) {
        if (n % 5 == 0) {
            queue.add("buzz");
            //System.out.println("buzz");
        }
    }

    public void fizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            queue.add("fizzbuzz");
            //System.out.println("fizzbuzz");
        }
    }

    public void notFizzBuzz(int n) {

        if (n % 3 != 0 && n % 5 != 0) {
            queue.add(String.valueOf(n));
            //System.out.println(n);
        }
    }
}
