package nowcoder;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数
 * 序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有
 * 和为S的连续正数序列? Good Luck!
 *
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class ContinuousPositiveSequenceWithSumS {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int pLow = 1;
        int pHigh = 2;
        while (pLow < pHigh) {
            // 等差数列和： Sn = (a0 + an) * n / 2
            int cur = (pLow + pHigh) * (pHigh - pLow + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = pLow; i <= pHigh; i++) {
                    temp.add(i);
                }
                result.add(temp);
                ++pLow;
            } else if (cur < sum) {
                ++pHigh;
            } else {
                ++pLow;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // [ 9, 10, 11, 12, 13, 14, 15, 16 ] [ 18, 19, 20, 21, 22 ]
        System.out.println(new ContinuousPositiveSequenceWithSumS().FindContinuousSequence(100));
    }
}
