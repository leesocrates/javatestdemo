package javatest.ThreadTest;

public class ThreadExceptionTest {
    private static Object o;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                o.getClass();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (i<5){
                    System.out.println("i is : "+i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main exit");
    }
}
