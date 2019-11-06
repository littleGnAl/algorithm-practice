package nowcoder;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n <= 1) return n;

        int fn1 = 0;
        int fn2 = 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = fn1 + fn2;
            fn1 = fn2;
            fn2 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(39));
    }
}
