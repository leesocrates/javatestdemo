package algorightm.stack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Stack<E extends Object> {
    private E[] container;
    private int size=0;

//    public Stack(){
//        this(Object.class, 10);
//        ArrayList
//    }

    public Stack(Class<E> c, int initialCapacity){
        container =(E[]) Array.newInstance(c, initialCapacity);
    }

    public void push(E e){
        container[size++] = e;
    }

    public E pop() {
        if(size()==0){
            try {
                throw new Exception("stack is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return container[--size];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
