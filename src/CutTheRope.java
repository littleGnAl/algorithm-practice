/**
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 *
 * 示例1
 * 输入
 * 8
 *
 * 输出
 * 18
 */
public class CutTheRope {
    public int cutRope(int target) {
        if (target == 2) return 1;
        if (target == 3) return 2;

        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= target; i++) {
            int res = 0;
            for (int j = 1; j <= i / 2; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }

        return dp[target];
    }

    public static void main(String[] args) {
        // 18
        System.out.println(new CutTheRope().cutRope(8));
    }
}
