package algorightm.stack;

//import java.util.Stack;

public class ValidParentheses {
    public static boolean test(String code) {
        Stack<String> stack = new Stack<>(String.class, 100);
        char[] chars = code.toCharArray();// 把输入的字符串拆分成char一个一个读取
        for (char aChar : chars) {
            String s = String.valueOf(aChar);// char转String
            if ("{".equals(s) || "[".equals(s) || "(".equals(s)) {
                stack.push(String.valueOf(aChar));// 如果是开放符号就入栈
            }
            if (stack.isEmpty()) {
                // 如果栈是空的，就说明有关闭符号缺少相应的开放符号
                System.out.println("您的代码中有符号不对应");
                return false;
            }
            // 如果是关闭符号，则出栈最上层的元素进行比较
            // 如果是配对的符号，就说明是正确的；如果不是配对的符号，就说明是错误的
            switch (s) {
                case "}":
                    if (!"{".equals(stack.pop())) {
                        System.out.println("您的代码中有符号不对应");
                        return false;
                    }
                    break;
                case "]":
                    if (!"[".equals(stack.pop())) {
                        System.out.println("您的代码中有符号不对应");
                        return false;
                    }
                    break;
                case ")":
                    if (!"(".equals(stack.pop())) {
                        System.out.println("您的代码中有符号不对应");
                        return false;
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("您的代码中缺少闭合符号");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(test("{[]}"));// 正确
        System.out.println("————————————————————————————————");
        System.out.println(test("{[{}{}]"));// 缺少结尾"}"
        System.out.println("————————————————————————————————");
        System.out.println(test("{[{}{}]}}"));// 结尾多了一个"}"
        System.out.println("————————————————————————————————");
        System.out.println(test("{[{}{(}]}"));// 中间多了一个"("

    }
}
