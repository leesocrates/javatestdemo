package javatest.strings;

public class TestString {
//    public static void main(String[] args) {
//        final String m1 = "ja";
//        final String m2 = "va";
//         String m = m1 + m2;
//        String n = new String(new char[]{'j', 'a', 'v', 'a'});
//
//        System.out.println(n == m);
//    }

//    public static String s1="static";  // 第一句
//    public static void main(String[] args) {
//        String s1=new String("he")+new String("llo"); //第二句
////        s1.intern();   // 第三句
//        System.out.println(s1==s1.intern());//第五句，输出是true。
//        String s2="hello";  //第四句
//        System.out.println(s1==s2);//第五句，输出是true。
//        String n = new String(new char[]{'j', 'a', 'v', 'a'});
//        System.out.println(n == n.intern());
//    }

    public static void main(String[] args) {
        String s1 = new String("he") + new String("llo"); // ①
        String s2 = new String("h") + new String("ello"); // ②
        String s3 = s1.intern(); // ③
        String s4 = s2.intern(); // ④
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);

        String n = new String("world");
        System.out.println(n == n.intern());
    }

}
