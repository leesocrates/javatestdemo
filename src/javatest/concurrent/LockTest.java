package javatest.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class LockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.writeLock().lock();
        reentrantReadWriteLock.writeLock().lock();
        reentrantReadWriteLock.readLock().lock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantReadWriteLock.writeLock().lock();
                System.out.println("thread finish");
            }
        }).start();

        // lock()两次后，只有unlock()两次，别的thread里面的lock()方法才能获取到锁
        reentrantReadWriteLock.writeLock().unlock();
        reentrantReadWriteLock.writeLock().unlock();
        reentrantReadWriteLock.readLock().unlock();

        System.out.println("main finish");
        System.out.println("1<<1 is " + (1 >>> 1));
        testCondition();
    }

    private static void testCondition() {
        final ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(5);
        new Thread(new Runnable() {
            int index = 0;

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1500);
                        arrayBlockingQueue.put("" + index++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("queue put value is : " + index);
                }
            }
        }).start();
        new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                while (i < 5) {
                    try {
                        String s = arrayBlockingQueue.take();
                        System.out.println("queue take value is : " + s);
//                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        }).start();

    }

    private static void testStampedLock(){
        StampedLock stampedLock = new StampedLock();
        long stamp =stampedLock.tryOptimisticRead();
        if(!stampedLock.validate(stamp)){
            try {
               stamp = stampedLock.readLock();
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

    }
}
