/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其
 * 循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateTheString {
    public String LeftRotateString(String str,int n) {
        if (str.isEmpty()) return str;
        char[] strArr = str.toCharArray();
        int len = strArr.length;

        int k = n > len ? n % len : n;

        char[] newArr = new char[len];
        for (int i = 0; i < len; i++) {
            int l = i - k;
            if (l < 0) {
                l = len + l;
            }

            newArr[l] = strArr[i];
        }

        return new String(newArr);
    }

    public static void main(String[] args) {
        // XYZdefabc
        System.out.println(new LeftRotateTheString().LeftRotateString("abcXYZdef", 3));

        // YZdefabcX
        System.out.println(new LeftRotateTheString().LeftRotateString("abcXYZdef", 4));

        // XYZdefabc
        System.out.println(new LeftRotateTheString().LeftRotateString("abcXYZdef", 12));
    }
}
