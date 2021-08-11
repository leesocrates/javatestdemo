package javatest.reflection;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class TestClass {

    private String MSG = "Original";

    private void privateMethod(String head, int tail) {
        System.out.print(head + tail);
    }

    public String getMsg() {
        return MSG;
    }

    //String 会被 JVM 优化
    private final String FINAL_VALUE = "FINAL";

    public String getFinalValue() {
        //剧透，会被优化为: return "FINAL" ,拭目以待吧
        return FINAL_VALUE;
    }

    public static void main(String[] args) {
        System.out.println("Hello World! "+ (40*60*1000) / 40 * 60 * 1000);
//        Integer integer = new Integer(0);
//        Integer next = new Integer(1);
//        if (next - integer == 1) {
//            System.out.println("equals 0");
//        }
//        new Object().getClass();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        int result = findMissingLog(arrayList);
//        System.out.println(result);
//        String s = "How is it going? :) You are almost done :-)!";
//        System.out.println(parseEmoticons(s));
//        int[] logs = {3, 1, 10, 2};
//        maxLogs(logs);
//
//        System.out.println("round result : "+roundPrice(5500, 3));
    }

    public static List<InlinedEmoticon> parseEmoticons(String text) {
        char lastChar = '0';
        int lastIndex = -1;
        ArrayList<InlinedEmoticon> arrayList1 = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char curChar = text.charAt(i);
            InlinedEmoticon inlinedEmoticon = null;
            if (lastChar == ':') {
                if (curChar == '(') {
                    inlinedEmoticon = new InlinedEmoticon(3, lastIndex, 2);
                    lastChar = '0';
                    lastIndex = -1;
                } else if (curChar == ')') {
                    inlinedEmoticon = new InlinedEmoticon(1, lastIndex, 2);
                    lastChar = '0';
                    lastIndex = -1;
                } else if (curChar == '/') {
                    inlinedEmoticon = new InlinedEmoticon(2, lastIndex, 2);
                    lastChar = '0';
                    lastIndex = -1;
                } else if (curChar == '-') {
                    lastChar = '-';
                } else {
                    lastChar = '0';
                    lastIndex = -1;
                }
            } else if (lastChar == '-') {
                if (curChar == ')') {
                    inlinedEmoticon = new InlinedEmoticon(1, lastIndex, 3);
                } else if (curChar == '(') {
                    inlinedEmoticon = new InlinedEmoticon(3, lastIndex, 3);
                }
                lastChar = '0';
                lastIndex = -1;
            }
            if (curChar == ':') {
                lastChar = curChar;
                lastIndex = i;
            }
            if (inlinedEmoticon != null) {
                arrayList1.add(inlinedEmoticon);
            }
        }
        return arrayList1;
//        throw new UnsupportedOperationException("Parsing not implemented");
    }

    public static class InlinedEmoticon {
        final int emoticonId;
        final int position;
        final int length;

        public InlinedEmoticon(int emoticonId, int position, int length) {
            this.emoticonId = emoticonId;
            this.position = position;
            this.length = length;
        }
    }

    public static int findMissingLog(List<Integer> sortedLogIds) {
        Iterator<Integer> iterator = sortedLogIds.iterator();
        Integer result = iterator.next();
        System.out.println("first result is " + result);
        if (result != 1) {
            return result;
        }
        while (iterator.hasNext()) {
            Integer curInteger = iterator.next();
            System.out.println(" curInteger is " + curInteger);
            System.out.println("curInteger-result: " + (curInteger - result));
            if (curInteger - result != 1) {
                result += 1;

                break;
            }
            result = curInteger;
        }
        return result;
    }

    static int maxLogs(int[] logsCount) {
        int[] indexs = new int[logsCount.length];
        int lastMax = 0;
        for (int i = 0; i < logsCount.length; i++) {
            int[] result = findMax(logsCount, lastMax);
            int index = result[0];
            if (index + 1 < indexs.length - 1) {
                if (indexs[index + 1] > 0) {
                    continue;
                }
            }
            if (index - 1 >= 0) {
                if (indexs[index - 1] > 0) {
                    continue;
                }
            }
            lastMax = result[1];
            indexs[result[0]] = result[1];
        }

        int result = 0;
        for (int i = 0; i < indexs.length; i++) {
            result += indexs[i];
        }

        System.out.println("result is "+result );

        return result;
    }

    static int[] findMax(int[] logsCount, int upperMax) {
        int max = 0;
        int maxIndex = 0;
        int[] result = new int[2];
        for (int i = 0; i < logsCount.length; i++) {
            if (logsCount[i] > max) {
                if (upperMax == 0 || (upperMax != 0 && logsCount[i] < upperMax)) {
                    max = logsCount[i];
                    maxIndex = i;
                }
            }
        }
        result[0] = maxIndex;
        result[1] = max;
        return result;
    }

    public static long roundPrice(int price, int n) {
        String sPrice = price+"";
        char[] results = sPrice.toCharArray();
        if(n<=sPrice.length()-1){
            for(int i=0; i<sPrice.length(); i++){
                if(i>sPrice.length()-n){
                    results[i] = '0';
                } else {
                    results[i] = sPrice.charAt(i);
                }
                if(i==sPrice.length()-n){
                    if(results[i]>='5'){
                        results[i-1] += 1;
                    }
                    results[i] = '0';
                }
            }
        }
        String result = new String(results);
        return Integer.parseInt(result);
    }
}
