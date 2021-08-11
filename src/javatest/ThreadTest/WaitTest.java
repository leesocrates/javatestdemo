package javatest.ThreadTest;

public class WaitTest {
    private volatile int i = 0;

    public static void main(String[] args) {
        MyThread myThread = new MyThread("T1");
//        MyThread myThread2 = new MyThread("T2");
//        MyThread myThread3 = new MyThread("T3");
        myThread.start();
//        try {
//            myThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("myThread run finished ");
//        myThread2.start();

//        myThread3.start();
    }

    private static class MyThread extends Thread{
        private String name;
        private static Object locker = new Object();
        private static Object locker2 = new Object();

        public MyThread(String name){
            super(name);
            this.name=name;
        }

        @Override
        public void run() {
            System.out.println("run start "+name);
            synchronized(locker){
                System.out.println("synchronize start "+name);
                locker.notifyAll();
//                try {
                    locker2.notify();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("synchronized finish "+name);
            }
        }
    }
}
