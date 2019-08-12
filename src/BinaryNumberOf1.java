/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class BinaryNumberOf1 {
    public int NumberOf1(int n) {
        int sum = 0;
        while (n != 0) {
            ++sum;
            n = n & (n - 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        // 0
        System.out.println(new BinaryNumberOf1().NumberOf1(0));
        // 1
        System.out.println(new BinaryNumberOf1().NumberOf1(1));
        // 32
        System.out.println(new BinaryNumberOf1().NumberOf1(-1));
        // 1
        System.out.println(new BinaryNumberOf1().NumberOf1(-2147483648));
    }
}
