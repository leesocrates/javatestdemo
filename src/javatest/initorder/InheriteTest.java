package javatest.initorder;

public class InheriteTest {
    public static void main(String[] args) {
        B b = new B();
    }

    public static class A{
        public A(){
            System.out.println("A Constructor");
        }

        public A(int i){
            System.out.println("A Constructor i is : "+i);
        }
    }

    public static class B extends A{
        public B(){
//            System.out.println("B Constructor");
        }

        public B(int i){
//            System.out.println("B Constructor");
        }


    }

}
