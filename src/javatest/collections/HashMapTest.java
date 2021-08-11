package javatest.collections;

import java.util.Arrays;

public class HashMapTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        System.out.println("table size 16 tableszefor is "+tableSizeFor(16));
        System.out.println("10000 % 1000 : "+9100/1000 % 10);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
