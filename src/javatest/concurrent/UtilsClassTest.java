package javatest.concurrent;

import java.util.concurrent.*;

/**
 * 并发工具类测试
 */
public class UtilsClassTest {

    public static void main(String[] args) {
//        testSemaphore();
//        testCountDownLatch();
//        testCyclicBarrier();
//        testExchanger();
        testPhaser();
    }

    private static void testSemaphore() {
        // 初始值为1，为排他锁，但是如果多次联系调用release（）之后，则可以多次调用acquire()不阻塞
        Semaphore semaphore = new Semaphore(1, true);
        try {
            System.out.println("acquire before");
            semaphore.acquire();
            System.out.println("acquire after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        semaphore.release();
        try {
            System.out.println("acquire before");
            semaphore.acquire();
            System.out.println("acquire after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("acquire before");
            semaphore.acquire();
            System.out.println("acquire after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("countDownLatch await ...");
                    countDownLatch.await();
                    System.out.println("countDownLatch await finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("countDownLatch await ...");
                    countDownLatch.await();
                    System.out.println("countDownLatch await finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        countDownLatch.countDown();
    }

    private static void testCyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    System.out.println("cyclicBarrier finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            cyclicBarrier.await();
            System.out.println("cyclicBarrier finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static int i = 0;

    private static void testExchanger() {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = exchanger.exchange("" + i++);
                    System.out.println("thread1 s is : "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = exchanger.exchange("" + i++);
                    System.out.println("thread2 s is : "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = exchanger.exchange("" + i++);
                    System.out.println("thread3 s is : "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = exchanger.exchange("" + i++);
                    System.out.println("thread4 s is : "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void testPhaser(){
        Phaser phaser = new Phaser(2);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("await phase "+phaser.getPhase());
//                phaser.awaitAdvance(0);
//                System.out.println("arrive phase "+phaser.getPhase());
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                phaser.arrive();
//                phaser.arrive();
//                System.out.println("arrive invoke phase is "+phaser.getPhase());
//            }
//        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                phaser.arriveAndAwaitAdvance();
                System.out.println("arrive invoke phase is "+phaser.getPhase());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                phaser.arriveAndAwaitAdvance();
                System.out.println("arrive invoke phase is "+phaser.getPhase());
            }
        }).start();
    }
}
