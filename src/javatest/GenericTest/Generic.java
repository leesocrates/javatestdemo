package javatest.GenericTest;

import java.util.*;

public class Generic<T> implements GenericInterface<T> {

    @Override
    public void doSomething(T o) {

    }

    public static void main(String[] args) {
//        List<Object> list = new ArrayList<String>();  // error
        List<? extends Object> list = new ArrayList<>();

        List<? super String> listSuper = new ArrayList<>();
        listSuper.add("a");
        List<String> listString = new ArrayList<>();
        listString.add("a");
//        ArrayList
//        Set
//        LinkedHashMap
//        Vector
//        StringBuilder
    }

}
