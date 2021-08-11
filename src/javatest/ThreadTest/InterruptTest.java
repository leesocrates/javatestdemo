package javatest.ThreadTest;

import java.util.concurrent.*;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread t run name ： "+Thread.currentThread().getName());
            }
        });
        t.start();
        MyThread myThread = new MyThread();
        myThread.start();
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        System.out.println("mythread is "+myThread.isInterrupted()+ " isalive: "+myThread.isAlive());
        myThread.interrupt();
        Thread.sleep(1000);
        System.out.println("mythread is "+myThread.isInterrupted()+ " isalive: "+ myThread.isAlive());


        Callable<String> callable = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(callable);
        new Thread(ft,"threadName").start();
        System.out.println(ft.get());

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 30,
                1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(6));
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread run name : "+ this.getName());
        int i=0;
        while (!isInterrupted()){
            i++;
            try {
                Thread.sleep(1000);
                synchronized(this) {
                    this.wait();
                }

                System.out.println("MyThread run name : "+ this.getName()+ " i is : "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("MyRunnable run name: "+Thread.currentThread().getName());
    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" callable is running");
        return Thread.currentThread().getName();
    }
}
