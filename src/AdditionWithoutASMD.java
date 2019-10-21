/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class AdditionWithoutASMD {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int t = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = t;
        }

        return num1;
    }

    public static void main(String[] args) {
        // 4
        System.out.println(new AdditionWithoutASMD().Add(1, 3));
    }
}
