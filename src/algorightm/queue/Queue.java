package algorightm.queue;

import java.util.Deque;

public class Queue<E> {
    private Object[] data = null;// 队列
    private int front;// 队列头，允许删除
    private int rear;// 队列尾，允许插入

    public Queue() {
        this(10);// 默认队列的大小为10
    }

    public Queue(int initialSize) {
        data = new Object[initialSize];
        front = rear = 0;
    }

    // 入列一个元素
    public void offer(E e) {
        data[rear++] = e;
    }

    // 返回队首元素，但不删除
    public E peek() {
        return (E) data[front];
    }

    // 出队排在最前面的一个元素
    public E poll() {
        E value = (E) data[front];// 保留队列的front端的元素的值
        data[front++] = null;// 释放队列的front端的元素
        return value;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        System.out.println("当前第一个元素: " + queue.peek());// 取队列第一个元素
        System.out.println("出列第一个元素: " + queue.poll());// 出列第一个元素
        System.out.println("当前第一个元素: " + queue.peek());// 取队列第一个元素
    }
}