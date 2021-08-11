package javatest.initorder;

class SingleTonTest {
    private static SingleTonTest singleTon = new SingleTonTest();
    public static int count1 ;
    public static int count2 = 2;

    private SingleTonTest() {
        count1++;
        count2++;
        System.out.println("SingleTonTest count1=" + singleTon.count1);
        System.out.println("SingleTonTest count2=" + singleTon.count2);
    }

    public static SingleTonTest getInstance() {
        return singleTon;
    }
}

public class SingleTon {
    public static void main(String[] args) {
        SingleTonTest singleTon = SingleTonTest.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
