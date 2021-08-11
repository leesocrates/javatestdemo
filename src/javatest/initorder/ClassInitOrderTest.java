package javatest.initorder;

import java.util.ArrayList;
import java.util.LinkedList;

public class ClassInitOrderTest {

    public static String staticField = "static field";

    static {
        System.out.println(staticField);
        System.out.println("static block");
    }



    private String field = "member field";

    {
        System.out.println(field);
        System.out.println("non-static block");
    }

    public ClassInitOrderTest() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        new ClassInitOrderTest();
    }

}