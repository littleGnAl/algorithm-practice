package nowcoder;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumOfOneToN {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean t = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        // 6
        System.out.println(new SumOfOneToN().Sum_Solution(3));
    }
}
