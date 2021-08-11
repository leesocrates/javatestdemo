package javatest.collections;

import sun.misc.LRUCache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("1", "1");
        linkedHashMap.put("2", "2");
        linkedHashMap.put("3", "3");
        linkedHashMap.put("4", "4");

        Iterator<Map.Entry<String, String>> iterable = linkedHashMap.entrySet().iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }

        System.out.println();

        linkedHashMap.get("2");
        Iterator<Map.Entry<String, String>> iterable1 = linkedHashMap.entrySet().iterator();
        while (iterable1.hasNext()){
            System.out.println(iterable1.next());
        }
    }
}
