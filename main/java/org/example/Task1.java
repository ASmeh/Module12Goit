package org.example;

class Thread1 extends Thread {
    public Thread1(){
        start();
    }
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while(true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            int seconds = (int) (elapsedTime / 1000);
            int minutes = seconds / 60;
            int hours = minutes / 60;
            seconds = seconds % 60;
            minutes = minutes % 60;

            System.out.printf("Час що минув від початку программи: %02d:%02d:%02d\n", hours, minutes, seconds);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 extends Thread {
    public Thread2() {
        start();
    }
    @Override
    public void run() {
        while (true) {
            try{
                Thread.sleep(5000);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Минуло 5 секунд.");
        }
    }
}
public class Task1 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
    }
}
