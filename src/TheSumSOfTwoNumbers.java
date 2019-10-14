import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class TheSumSOfTwoNumbers {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int pLow = 0;
        int pHigh = array.length - 1;
        int preNum1 = 0;
        int preNum2 = 0;

        while (pLow < pHigh) {
            int num1 = array[pLow];
            int num2 = array[pHigh];
            int temp = num1 + num2;
            if (temp == sum) {
                if (preNum1 * preNum2 == 0 || (preNum1 * preNum2 > num1 * num2)) {
                    preNum1 = num1;
                    preNum2 = num2;
                }

                ++pLow;
                --pHigh;
            } else if (temp < sum) {
                ++pLow;
            } else {
                --pHigh;
            }
        }

        if (preNum1 != 0 && preNum2 != 0) {
            result.add(preNum1);
            result.add(preNum2);
        }

        return result;
    }

    public static void main(String[] args) {
        // [1, 12]
        System.out.println(new TheSumSOfTwoNumbers().FindNumbersWithSum(new int[] { 1, 3, 5, 10, 12 }, 13));
    }
}
