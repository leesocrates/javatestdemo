package javatest.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {
        final AtomicInteger integer = new AtomicInteger();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (integer.get()<150){
                    integer.getAndIncrement();
                    System.out.println("thread integer is : "+integer.get());
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (integer.get()<150){
                    integer.getAndIncrement();
                    System.out.println("thread1 integer is : "+integer.get());
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (integer.get()<150){
                    integer.getAndIncrement();
                    System.out.println("thread2 integer is : "+integer.get());
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (integer.get()<150){
                    integer.getAndIncrement();
                    System.out.println("thread3 integer is : "+integer.get());
                }
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (integer.get()<150){
                    integer.getAndIncrement();
                    System.out.println("thread4 integer is : "+integer.get());
                }
            }
        });

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        testAtomicFieldUpdater();
    }

    private static void testAtomicFieldUpdater(){
//        AtomicReferenceFieldUpdater.newUpdater()
    }

}
