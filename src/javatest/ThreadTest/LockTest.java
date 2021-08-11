package javatest.ThreadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {


        ReadThread readThread = new ReadThread("r1");
        ReadThread readThread2 = new ReadThread("r2");
        readThread.start();
        readThread2.start();

        WriteThread writeThread = new WriteThread("w1");
        WriteThread writeThread2 = new WriteThread("w2");
        writeThread.start();
        writeThread2.start();
    }

    static class WriteThread extends Thread {
        private String name;

        public WriteThread(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {
            super.run();
//            try {
//                reentrantReadWriteLock.writeLock().tryLock(3, TimeUnit.SECONDS);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("running thread is " + name);
        }
    }

    static class ReadThread extends Thread {
        private String name;

        public ReadThread(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {
            super.run();
            reentrantReadWriteLock.readLock().tryLock();
            System.out.println("running thread is " + name);
//            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
