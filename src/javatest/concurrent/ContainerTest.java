package javatest.concurrent;

import java.util.concurrent.*;

/**
 * 并发容器测试
 */
public class ContainerTest {

    public static void main(String[] args) {
//        testBlockingQueue();
//        testSynchronousQueue();
        testCopyOnWrite();
    }

    private static void testSynchronousQueue(){
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 invoke put()");
                try {
                    synchronousQueue.put("1");
                    System.out.println("thread1 invoke put() finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 invoke put()");
                try {
                    synchronousQueue.put("2");
                    System.out.println("thread2 invoke put() finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread3 invoke take()");
                try {
                    String s = synchronousQueue.take();
                    System.out.println("thread3 invoke take() finish value is : "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void testBlockingQueue() {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.offer("2");
        arrayBlockingQueue.remove();
        arrayBlockingQueue.peek();
        try {
            arrayBlockingQueue.put("3");
            String s = arrayBlockingQueue.take();
            System.out.println("take s is " + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        try {
            linkedBlockingQueue.put("1");
            linkedBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();
        try {
            priorityBlockingQueue.put("1");
            priorityBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        try {
            blockingDeque.putFirst("1");
            blockingDeque.putLast("2");
            blockingDeque.takeFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void testCopyOnWrite(){
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.get(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0 ; i<10000; i++){
                    int size  = copyOnWriteArrayList.size();
                    System.out.println("add thread size is "+size+ " value is : "+copyOnWriteArrayList.add(i+""));
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i =0 ; i<10000; i++){
                            int size  = copyOnWriteArrayList.size();
                            System.out.println("get thread size is "+size+ " value is : "+copyOnWriteArrayList.get(size-1));
                        }

                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i =0 ; i<10000; i++){
                            int size  = copyOnWriteArrayList.size();
                            System.out.println("get thread size is "+size+ " value is : "+copyOnWriteArrayList.get(size-1));
                        }

                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i =0 ; i<10000; i++){
                            int size  = copyOnWriteArrayList.size();
                            System.out.println("get thread size is "+size+ " value is : "+copyOnWriteArrayList.get(size-1));
                        }

                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i =0 ; i<10000; i++){
                            int size  = copyOnWriteArrayList.size();
                            System.out.println("remove thread size is "+size+ " value is : "+copyOnWriteArrayList.remove(size-1));
                        }

                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i =0 ; i<10000; i++){
                            int size  = copyOnWriteArrayList.size();
                            System.out.println("remove thread size is "+size+ " value is : "+copyOnWriteArrayList.remove(size-1));
                        }

                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i =0 ; i<10000; i++){
                            int size  = copyOnWriteArrayList.size();
                            System.out.println("remove thread size is "+size+ " value is : "+copyOnWriteArrayList.remove(size-1));
                        }

                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i =0 ; i<10000; i++){
                            int size  = copyOnWriteArrayList.size();
                            System.out.println("remove thread size is "+size+ " value is : "+copyOnWriteArrayList.remove(size-1));
                        }

                    }
                }).start();
            }
        }).start();
    }

    private static void testConcurrentLinkedQueue(){
        ConcurrentLinkedQueue<String> concurrentLinkeQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkeQueue.offer("1");
        concurrentLinkeQueue.poll();
    }
}
