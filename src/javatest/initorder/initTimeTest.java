package javatest.initorder;

/**
 * 类初始化时，变量，代码块，构造函数初始化顺序
 */
public class initTimeTest {
    private static A a = new A();

    static {
        System.out.println("static block");
    }

    private static B b = new B();

    public static void main(String[] args) {
        new initTimeTest();
    }

}
class A {
    public A() {
        System.out.println("static field A");
    }
}

class B {
    public B() {
        System.out.println("static field B");
    }
}