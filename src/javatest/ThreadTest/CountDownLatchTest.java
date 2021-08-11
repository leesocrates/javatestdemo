package javatest.ThreadTest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread.start();
        myThread2.start();
        myThread3.start();
        try {
            countDownLatch.await();
            System.out.println("countDownLatch is zero");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyThread extends  Thread{
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }
}
